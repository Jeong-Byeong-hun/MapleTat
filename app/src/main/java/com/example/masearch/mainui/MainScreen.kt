package com.example.masearch.mainui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.MainViewModel
import com.example.masearch.R
import com.example.masearch.Stats
import com.example.masearch.api.vo.BaseVo
import com.example.masearch.screen.Screen
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(navController: NavController) {

    var id by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen 1")
        TextField(
            value = id,
            onValueChange = { s -> id = s },
            placeholder = { Text(text = "아이디를 입력해주세요.") },
            singleLine = true
        )
        Button(onClick = { navController.navigate(Screen.SearchScreen.searchCharacter(id.text.toString())) }) {
            Text(text = "Navigate to next screen")
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ParallaxEffect(
    navigateBack: () -> Unit,
    id: String?,
    viewModel: MainViewModel
) {
    val state = rememberCollapsingToolbarScaffoldState()
    var showDialog by remember { mutableStateOf(false) }
    var receivedText by remember { mutableStateOf(id.orEmpty()) }
    var enabled by remember { mutableStateOf(true) }
    val context = LocalContext.current
    Log.d("TAG", "ParallaxEffect: receivedText " + receivedText)
    Log.d("TAG", "ParallaxEffect: ID " + id)


    LaunchedEffect(key1 = receivedText) {
        receivedText.let {
            if (receivedText.isNotEmpty()) {
                viewModel.getUserData(it)
            }

        }
    }

    val userData by viewModel.userData.observeAsState()

    Box {
        CollapsingToolbarScaffold(modifier = Modifier.fillMaxSize(),
            state = state,
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            toolbarModifier = Modifier.background(Color.DarkGray),
            enabled = enabled,
            toolbar = {
                // Collapsing toolbar collapses its size as small as the that of
                // a smallest child. To make the toolbar collapse to 50dp, we create
                // a dummy Spacer composable.
                // You may replace it with TopAppBar or other preferred composable.

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.DarkGray)
                ) {

                    GlideImage(
                        model = ContextCompat.getDrawable(context, R.mipmap.perv_btn),
                        contentDescription = "back",
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clickable(onClick = navigateBack)
                            .align(Alignment.CenterVertically)
                            .padding(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )

                    val textModifier = Modifier
                        .graphicsLayer {
                            alpha = (1f - state.toolbarState.progress)
                        }
                        .align(Alignment.CenterVertically)

                    ToolbarNickName(modifier = textModifier, userData = userData)

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    GlideImage(model = ContextCompat.getDrawable(context, R.mipmap.search),
                        contentDescription = "search",
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clickable {
                                showDialog = true
                                Log.d("TAG", "ParallaxEffect: search")
                            }
                            .padding(12.dp)
                            .align(Alignment.CenterVertically))

                    if (showDialog) {
                        SearchDialog(onDismiss = { showDialog = false },
                            onSearch = { searchText ->
                                // 검색 버튼을 누를 때 호출되는 콜백
                                if (searchText.isEmpty()) {
                                    return@SearchDialog
                                }

                                receivedText = searchText.trim()
                                viewModel.getUserData(searchText)
                            })

                    }
                }

                val glideModifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .graphicsLayer {
                        alpha = (state.toolbarState.progress)
                    }

                ToolbarView(userData = userData, glideModifier = glideModifier)

            }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
            ) {
                MainAvatar(userData = userData)
            }

        }

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.DarkGray)
//        ) {
//            MainAvatar(userData = userData)
//        }

    }
}

@Composable
fun ToolbarNickName(modifier: Modifier, userData: BaseVo?) {

    if (userData != null) {
        if (userData.characterVo == null) {
            return
        }

        Text(
            text = userData.characterVo.name,
            modifier = modifier,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontFamily = FontFamily(
                Font(
                    R.font.notosans_regular, FontWeight.Normal, FontStyle.Normal
                )
            )
        )

    }

}

@Composable
fun CharacterInfoText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        color = Color.White,
        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
        fontFamily = FontFamily(
            Font(
                R.font.notosans_regular, FontWeight.Normal, FontStyle.Normal
            )
        )
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ToolbarView(userData: BaseVo?, glideModifier: Modifier) {

    if (userData != null) {
        Box(
            contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxWidth()
        ) {

            GlideImage(
                model = userData.characterVo.image,
                contentDescription = "avatar",
                modifier = glideModifier
            )

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                Spacer(
                    modifier = Modifier.height(130.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {

                    CharacterInfoText(text = userData.characterVo.level)
                    Spacer(modifier = Modifier.width(8.dp))
                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CharacterInfoText(text = userData.characterVo.world)

                    Spacer(modifier = Modifier.width(8.dp))
                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    CharacterInfoText(
                        text = userData.characterVo.name + "  " + userData.characterVo.role.substring(
                            userData.characterVo.role.indexOf("/") + 1
                        )
                    )

                }
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            }
        }
    }
}


@Composable
fun MainAvatar(userData: BaseVo?) {

    if (userData != null) {
        if (userData.characterVo == null) return

        Stats(charInfo = userData.characterVo, items = userData.items)
    }
}
