package com.example.masearch

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.mainui.SearchDialog
import com.example.masearch.ui.theme.MaSearchTheme
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var activity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate: ")
        activity = this

        setContent {
            MaSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    ParallaxEffect(viewModel, activity)

                }
            }
        }

    }


    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun KotlinWorldDialog(modifier: Modifier, drawable: Drawable?) {
        var showDialog by remember { mutableStateOf(false) }
        var searchResult by remember { mutableStateOf<String?>(null) }

        GlideImage(model = drawable,
            contentDescription = "search",
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clickable {
                    showDialog = true
                    Log.d("TAG", "ParallaxEffect: search")
                }
                .padding(12.dp))

        if (showDialog) {
            SearchDialog(onDismiss = { showDialog = false }, onSearch = { searchText ->
                // 검색 버튼을 누를 때 호출되는 콜백
                searchResult = "검색 결과: $searchText"
                viewModel.getUserData(searchText)
            })

//            Dialog(onDismissRequest = {
//                showDialog = false
//                viewModel.getUserData("signer001")
//            }) {
//                Surface(
//                    modifier = Modifier
//                        .width(200.dp)
//                        .wrapContentHeight(),
//                    shape = RoundedCornerShape(12.dp),
//                    color = Color.White
//                ) {
//                    DialogContent()
//                }
//            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ParallaxEffect(viewModel: MainViewModel, activity: MainActivity) {
        val state = rememberCollapsingToolbarScaffoldState()
        var showDialog by remember { mutableStateOf(false) }
        var receivedText by remember { mutableStateOf("CyberPsycho") }

        var enabled by remember { mutableStateOf(true) }


        LaunchedEffect(key1 = Unit) {
            viewModel.getUserData(receivedText)
        }

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

                        GlideImage(model = activity.getDrawable(R.mipmap.perv_btn),
                            contentDescription = "back",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .clickable {
                                    Log.d("TAG", "ParallaxEffect: perv_btn")
                                }
                                .align(CenterVertically)
                                .padding(12.dp))



                        Spacer(
                            modifier = Modifier.width(4.dp)
                        )

                        val textModifier = Modifier
                            .graphicsLayer {
                                alpha = (1f - state.toolbarState.progress)
                            }
                            .align(CenterVertically)

                        ToolbarNickName(name = receivedText, textModifier)

//                    Text(
//                        text = "xzI존토벤x",
//                        modifier = Modifier
//                            .graphicsLayer {
//                                alpha = (1f - state.toolbarState.progress)
//                            }
//                            .align(CenterVertically),
//                        textAlign = TextAlign.Center,
//                        fontSize = 16.sp,
//                        color = Color.White
//                    )

                        Spacer(
                            modifier = Modifier.weight(1f)
                        )

                        GlideImage(model = activity.getDrawable(R.mipmap.search),
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

                                    receivedText = searchText
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


                    ToolbarView(viewModel = viewModel, glideModifier = glideModifier)

                }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                ) {
                    MainAvatar(viewModel = viewModel)
                }


            }

        }
    }

    @Composable
    fun ToolbarNickName(name: String, modifier: Modifier) {
        Text(
            text = name,
            modifier = modifier,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontFamily = FontFamily(
                Font(
                    R.font.notosans_regular,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
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
                    R.font.notosans_regular,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun ToolbarView(viewModel: MainViewModel, glideModifier: Modifier) {
        val temp = viewModel.getData().observeAsState()

        if (temp.value != null) {
            if (temp.value?.characterVo == null) {
                return
            }

            Box(
                contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxWidth()
            ) {
                GlideImage(
                    model = temp.value!!.characterVo.image,
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

                        CharacterInfoText(text = temp.value!!.characterVo.level)
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        CharacterInfoText(text = temp.value!!.characterVo.world)

                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        CharacterInfoText(text = temp.value!!.characterVo.name)

                    }
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }
            }
        }
    }


    @Composable
    fun MainAvatar(viewModel: MainViewModel) {
        val temp = viewModel.getData().observeAsState()

        if (temp.value != null) {
            if (temp.value?.characterVo == null)
                return

            Stats(charInfo = temp.value!!.characterVo, items = temp.value!!.items)
        }
    }
}



