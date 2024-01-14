package com.example.masearch.mainui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.MainViewModel
import com.example.masearch.R
import com.example.masearch.Stats
import com.example.masearch.api.vo.FinalStatVO
import com.example.masearch.api.vo.ResultVO
import com.example.masearch.room.LikeCharacterViewModel
import com.example.masearch.room.RecentSearchViewModel
import com.example.masearch.screen.Screen
import com.example.masearch.ui.theme.CombatPowerBackgroundColor
import com.example.masearch.ui.theme.CombatPowerTextColor
import com.example.masearch.ui.theme.LikeBackgroundColor
import com.example.masearch.ui.theme.MainBackgroundColor
import com.example.masearch.util.convertToCombatPower
import com.example.masearch.util.noRippleClickable
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun MainView(navController: NavController) {

    var id by remember { mutableStateOf(TextFieldValue("")) }
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(MainBackgroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            GlideImage(
//                model = ContextCompat.getDrawable(LocalContext.current, R.mipmap.mapletat),
//                contentDescription = null
//            )
            Image(painter = painterResource(id = R.mipmap.mapletat), contentDescription = "")

//            Text(
//                text = "MapleTat", fontSize = 26.sp,
//                fontFamily = FontFamily(
//                    Font(
//                        R.font.notosans_bold,
//                        FontWeight.Normal,
//                        FontStyle.Normal
//                    )
//                ),
//                color = Color.White
//            )

            Spacer(modifier = Modifier.height(16.dp))
            MainTextField(
                value = id.text.toString(),
                onValueChange = { s -> id = TextFieldValue(s) },
                placeholder = "닉네임을 입력해주세요",
                onTrailingIconClick = {
                    if (id.text.isEmpty() && snackbarHostState.currentSnackbarData == null) {
                        coroutineScope.launch() {
                            snackbarHostState.showSnackbar(
                                message = "아이디를 입력해주세요.",
                                actionLabel = "닫기",
                                duration = SnackbarDuration.Short
                            ).let {

                            }
                        }
                    } else if (id.text.isNotEmpty()) {
                        navController.navigate(Screen.SearchScreen.searchCharacter(id.text.toString()))
                    }
                },
                keyboardActionsClick = {
                    if (id.text.isEmpty() && snackbarHostState.currentSnackbarData == null) {
                        coroutineScope.launch() {
                            snackbarHostState.showSnackbar(
                                message = "아이디를 입력해주세요.",
                                actionLabel = "닫기",
                                duration = SnackbarDuration.Short
                            ).let {

                            }
                        }
                    } else if (id.text.isNotEmpty()) {
                        navController.navigate(Screen.SearchScreen.searchCharacter(id.text.toString()))
                    }
                }
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                MainTextView(text = "최근 검색 기록", onTextClick = {
                    navController.navigate(Screen.RecentSearchScreen.route)
                })
                Divider(
                    modifier = Modifier
                        .padding(10.dp, 0.dp, 10.dp, 0.dp)
                        .width(1.dp)
                        .height(24.dp),
                    thickness = 1.dp,
                    color = Color.White
                )
                MainTextView(text = "즐겨찾기", onTextClick = {
                    navController.navigate(Screen.LikeScreen.route)
                })
            }
        }
    }
}

@Composable
fun MainTextView(text: String, onTextClick: () -> Unit) {
    Text(
        text = text, modifier = Modifier.noRippleClickable { onTextClick() },
        fontSize = 20.sp,
        fontFamily = FontFamily(
            Font(
                R.font.notosans_regular,
                FontWeight.Normal,
                FontStyle.Normal
            )
        ),
        color = Color.White
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    onTrailingIconClick: () -> Unit,
    keyboardActionsClick: () -> Unit
) {
    TextField(
        modifier = Modifier
            .padding(52.dp, 0.dp, 52.dp, 0.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(90.dp),
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            platformStyle = PlatformTextStyle(includeFontPadding = false), fontSize = 20.sp,
            fontFamily = FontFamily(
                Font(
                    R.font.notosans_bold,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            ),
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(
                        R.font.notosans_bold,
                        FontWeight.Normal,
                        FontStyle.Normal
                    )
                ),
                color = Color.Black
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.mipmap.search),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.clickable {
                    onTrailingIconClick()
                }
            )
        },
        keyboardActions = KeyboardActions(onDone = {
            defaultKeyboardAction(ImeAction.Done)
            keyboardActionsClick()
        }),
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ParallaxEffect(
    navigateBack: () -> Unit,
    id: String?,
) {
    val state = rememberCollapsingToolbarScaffoldState()
    var showDialog by remember { mutableStateOf(false) }
    var receivedText by remember { mutableStateOf(id.orEmpty().trim()) }
    var enabled by remember { mutableStateOf(true) }
    var isExistCharacterLike by remember { mutableStateOf(false) }
    val context = LocalContext.current


    val viewModel: MainViewModel = hiltViewModel()
    val likeCharacterViewModel: LikeCharacterViewModel = hiltViewModel()
    val recentSearchViewModel: RecentSearchViewModel = hiltViewModel()

    LaunchedEffect(key1 = receivedText) {
        receivedText.let {
            if (receivedText.isNotEmpty()) {
                viewModel.getUserData(it)
                isExistCharacterLike = likeCharacterViewModel.isExistCharacter(receivedText)
                recentSearchViewModel.insertRecentName(receivedText)
            }
        }
    }

    val userData by viewModel.userData.observeAsState()
    val errorData by viewModel.errorLiveData.observeAsState()
    Column {
        CollapsingToolbarScaffold(modifier = Modifier.fillMaxSize(),
            state = state,
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            toolbarModifier = Modifier.background(MainBackgroundColor),
            enabled = enabled,
            toolbar = {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(MainBackgroundColor)
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

                    if (isExistCharacterLike) {
                        GlideImage(
                            model = ContextCompat.getDrawable(context, R.mipmap.star_full),
                            contentDescription = "like",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .clickable(onClick = {
                                    likeCharacterViewModel.deleteLikeCharacter(
                                        userData!!.basic.charName
                                    )
                                    isExistCharacterLike = false
                                })
                                .align(Alignment.CenterVertically)
                                .padding(8.dp),
                            colorFilter = ColorFilter.tint(LikeBackgroundColor)
                        )
                    } else {
                        GlideImage(
                            model = ContextCompat.getDrawable(context, R.mipmap.star),
                            contentDescription = "like",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .clickable(onClick = {
                                    if (userData?.basic == null)
                                        return@clickable

                                    likeCharacterViewModel.insertLikeCharacter(
                                        userData!!.basic.charName,
                                        userData!!.basic.charImage,
                                        userData!!.basic.level.toString()
                                    )
                                    isExistCharacterLike = true
                                })
                                .align(Alignment.CenterVertically)
                                .padding(8.dp)
                        )
                    }


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
                            .padding(8.dp)
                            .align(Alignment.CenterVertically),
                        colorFilter = ColorFilter.tint(Color.White)
                    )

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
                    .width(100.dp)
                    .height(100.dp)
                    .graphicsLayer {
                        alpha = (state.toolbarState.progress).coerceIn(0f, 1f)
                    }

                ToolbarView(userData = userData, glideModifier = glideModifier)

            }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MainBackgroundColor)
            ) {
                if (errorData != null) {
                    SearchFailedDialog(
                        errorData = errorData.toString(),
                        onDismiss = { viewModel.clearErrorData() })

                }
                MainAvatar(userData = userData)
            }

        }

    }
}

@Composable
fun ToolbarNickName(modifier: Modifier, userData: ResultVO?) {

    if (userData != null) {
        if (userData.basic.charName == null) {
            return
        }

        Text(
            text = userData.basic.charName,
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
        fontSize = 12.sp,
        color = Color.White,
        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
        fontFamily = FontFamily(
            Font(
                R.font.gmarket_sans_medium, FontWeight.Normal, FontStyle.Normal
            )
        )
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ToolbarView(userData: ResultVO?, glideModifier: Modifier) {

    if (userData != null) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GlideImage(
                    model = userData.basic.charImage,
                    contentDescription = "avatar",
                    modifier = glideModifier,
                    alignment = Alignment.TopCenter
                )
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
//                Spacer(
//                    modifier = Modifier.height(20.dp)
//                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {

                    CharacterInfoText(text = "Lv. " + userData.basic.level)

                    Spacer(modifier = Modifier.width(8.dp))

                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(0.dp, 2.dp, 0.dp, 2.dp), color = Color.LightGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    CharacterInfoText(text = userData.basic.worldName)

                    Spacer(modifier = Modifier.width(8.dp))

                    Divider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(0.dp, 2.dp, 0.dp, 2.dp), color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    CharacterInfoText(
                        text = userData.basic.charName + "  " + userData.basic.charClass
                    )

                }
                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                CombatPower(finalStatList = userData.stat.finalStatList)
            }
        }
    }
}

@Composable
fun MainAvatar(userData: ResultVO?) {

    if (userData != null) {
        if (userData.stat == null) return
        Stats(userData = userData)
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CombatPower(finalStatList: List<FinalStatVO>) {
    val context = LocalContext.current
    Surface(
        color = CombatPowerBackgroundColor,
        modifier = Modifier
            .padding(40.dp, 0.dp, 40.dp, 0.dp)
            .clip(shape = RoundedCornerShape(5.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CharacterInfoText(text = "전투력")
            Spacer(modifier = Modifier.width(16.dp))

            finalStatList[finalStatList.size - 2].statValue?.let { CombatPowerTextView(it) }

            Spacer(modifier = Modifier.width(16.dp))
            GlideImage(
                model = ContextCompat.getDrawable(context, R.mipmap.ignore_shield),
                contentDescription = "ignore_shield",
                modifier = Modifier
                    .width(18.dp)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            finalStatList[5].statValue?.let { IgnoreShieldTextView(it) }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}

@Composable
fun CombatPowerTextView(combatPower: String) {
    Log.d("TAG", "convertToCombatPower: " + combatPower)
    Text(
        text = convertToCombatPower(combatPower),
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        color = CombatPowerTextColor,
        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
        fontFamily = FontFamily(
            Font(
                R.font.gmarket_sans_bold, FontWeight.Normal, FontStyle.Normal
            )
        )
    )
}

@Composable
fun IgnoreShieldTextView(ignoreNum: String) {
    Text(
        text = "$ignoreNum%",
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        color = Color.White,
        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
        fontFamily = FontFamily(
            Font(
                R.font.gmarket_sans_bold, FontWeight.Normal, FontStyle.Normal
            )
        )
    )
}



