package com.example.masearch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.masearch.mainui.LikeCharacterHolder
import com.example.masearch.mainui.PToolbarView
import com.example.masearch.mainui.previewLikeCharacter
import com.example.masearch.ui.theme.MaSearchTheme
import com.example.masearch.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

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
//                Navigation(viewModel)
//                LikeCharacterHolder(10)
                previewLikeCharacter()
//                PToolbarView()

            }
        }

    }


//    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
//    @Composable
//    fun ParallaxEffect(viewModel: MainViewModel, activity: MainActivity) {
//        val state = rememberCollapsingToolbarScaffoldState()
//        var showDialog by remember { mutableStateOf(false) }
//        var receivedText by remember { mutableStateOf("CyberPsycho") }
//        var enabled by remember { mutableStateOf(true) }
//
//
////        LaunchedEffect(key1 = Unit) {
////            viewModel.getUserData(receivedText)
////        }
//
//        Box {
//            CollapsingToolbarScaffold(modifier = Modifier.fillMaxSize(),
//                state = state,
//                scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
//                toolbarModifier = Modifier.background(Color.DarkGray),
//                enabled = enabled,
//                toolbar = {
//                    // Collapsing toolbar collapses its size as small as the that of
//                    // a smallest child. To make the toolbar collapse to 50dp, we create
//                    // a dummy Spacer composable.
//                    // You may replace it with TopAppBar or other preferred composable.
//
//                    Spacer(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(150.dp)
//                    )
//
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(56.dp)
//                            .background(Color.DarkGray)
//                    ) {
//
//                        GlideImage(model = activity.getDrawable(R.mipmap.perv_btn),
//                            contentDescription = "back",
//                            modifier = Modifier
//                                .height(40.dp)
//                                .width(40.dp)
//                                .clickable {
//                                    Log.d("TAG", "ParallaxEffect: perv_btn")
//                                }
//                                .align(CenterVertically)
//                                .padding(12.dp))
//
//
//
//                        Spacer(
//                            modifier = Modifier.width(4.dp)
//                        )
//
//                        val textModifier = Modifier
//                            .graphicsLayer {
//                                alpha = (1f - state.toolbarState.progress)
//                            }
//                            .align(CenterVertically)
//
//                        ToolbarNickName(textModifier, viewModel)
//
//                        Spacer(
//                            modifier = Modifier.weight(1f)
//                        )
//
//                        GlideImage(model = activity.getDrawable(R.mipmap.search),
//                            contentDescription = "search",
//                            modifier = Modifier
//                                .height(40.dp)
//                                .width(40.dp)
//                                .clickable {
//                                    showDialog = true
//                                    Log.d("TAG", "ParallaxEffect: search")
//                                }
//                                .padding(12.dp)
//                                .align(Alignment.CenterVertically))
//
//                        if (showDialog) {
//                            SearchDialog(onDismiss = { showDialog = false },
//                                onSearch = { searchText ->
//                                    // 검색 버튼을 누를 때 호출되는 콜백
//                                    if (searchText.isEmpty()) {
//                                        return@SearchDialog
//                                    }
//
//                                    receivedText = searchText.trim()
//                                    viewModel.getUserData(searchText)
//                                })
//
//                        }
//                    }
//
//                    val glideModifier = Modifier
//                        .width(150.dp)
//                        .height(150.dp)
//                        .graphicsLayer {
//                            alpha = (state.toolbarState.progress)
//                        }
//
//                    ToolbarView(viewModel = viewModel, glideModifier = glideModifier)
//
//                }) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.DarkGray)
//                ) {
//                    MainAvatar(viewModel = viewModel)
//                }
//
//
//            }
//
//        }
//    }
//
//    @Composable
//    fun ToolbarNickName(modifier: Modifier, viewModel: MainViewModel) {
//        val temp = viewModel.getData().observeAsState()
//
//        if (temp.value != null) {
//            if (temp.value?.characterVo == null) {
//                return
//            }
//
//            Text(
//                text = temp.value!!.characterVo.name,
//                modifier = modifier,
//                textAlign = TextAlign.Center,
//                fontSize = 16.sp,
//                color = Color.White,
//                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
//                fontFamily = FontFamily(
//                    Font(
//                        R.font.notosans_regular, FontWeight.Normal, FontStyle.Normal
//                    )
//                )
//            )
//
//        }
//
//    }
//
//    @Composable
//    fun CharacterInfoText(text: String) {
//        Text(
//            text = text,
//            textAlign = TextAlign.Center,
//            fontSize = 16.sp,
//            color = Color.White,
//            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
//            fontFamily = FontFamily(
//                Font(
//                    R.font.notosans_regular, FontWeight.Normal, FontStyle.Normal
//                )
//            )
//        )
//    }
//
//    @OptIn(ExperimentalGlideComposeApi::class)
//    @Composable
//    fun ToolbarView(viewModel: MainViewModel, glideModifier: Modifier) {
//        val temp = viewModel.getData().observeAsState()
//        val errorValue = viewModel.getErrorLiveData().observeAsState()
//
//        var text = "아이디 또는 핸즈가 열려 있는지 확인해 주세요."
////        val snackState = remember { SnackbarHostState() }
////        val snackScope = rememberCoroutineScope()
//
//
////        SnackbarHost(
////            hostState = snackState,
////            Modifier
////                .fillMaxWidth()
////                .padding(4.dp)
////        )
////
////
////
////        fun launchSnackBar() {
////            snackScope.launch {
////                snackState.showSnackbar(
////                    text
////                )
////            }
////        }
//
//        if (errorValue.value?.isNotEmpty() == true) {
//            Log.d("MainViewModel", "ToolbarView: 에러에러")
//            Log.d("MainViewModel", "ToolbarView: " + temp.value.toString())
////            launchSnackBar()
//            viewModel.clearErrorData()
//        }
//
//        if (temp.value != null) {
//            if (temp.value?.characterVo == null) {
//                return
//            }
//
//            Box(
//                contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxWidth()
//            ) {
//
//                GlideImage(
//                    model = temp.value!!.characterVo.image,
//                    contentDescription = "avatar",
//                    modifier = glideModifier
//                )
//
//                Column(
//                    verticalArrangement = Arrangement.Top,
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight()
//
//                ) {
//                    Spacer(
//                        modifier = Modifier.height(130.dp)
//                    )
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(IntrinsicSize.Min),
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.Top
//                    ) {
//
//                        CharacterInfoText(text = temp.value!!.characterVo.level)
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Divider(
//                            modifier = Modifier
//                                .width(1.dp)
//                                .fillMaxHeight()
//                                .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        CharacterInfoText(text = temp.value!!.characterVo.world)
//
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Divider(
//                            modifier = Modifier
//                                .width(1.dp)
//                                .fillMaxHeight()
//                                .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//
//                        CharacterInfoText(
//                            text = temp.value!!.characterVo.name + "  " + temp.value!!.characterVo.role.substring(
//                                temp.value!!.characterVo.role.indexOf("/") + 1
//                            )
//                        )
//
//                    }
//                    Spacer(
//                        modifier = Modifier.height(8.dp)
//                    )
//                }
//            }
//        }
//    }
//
//
//    @Composable
//    fun MainAvatar(viewModel: MainViewModel) {
//        val temp = viewModel.getData().observeAsState()
//
//        if (temp.value != null) {
//            if (temp.value?.characterVo == null) return
//
//            Stats(charInfo = temp.value!!.characterVo, items = temp.value!!.items)
//        }
//    }

}



