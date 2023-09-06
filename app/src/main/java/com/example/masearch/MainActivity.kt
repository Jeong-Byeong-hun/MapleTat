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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.ui.theme.MaSearchTheme
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var activity: MainActivity
    private var testStr = "1234"

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

//                Column(
//                    verticalArrangement = Arrangement.Top,
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    MainAvatar(viewModel)
//
////                    CardItemGrade().GradeCardView(
////                        grade = "레전더리",
////                        cardColor = LegendaryBackgroundColor,
////                        textColor = LegendaryTextColor
////                    )
////                    Spacer(modifier = Modifier.weight(1f))
////                    CardItemGrade().GradeCardView(
////                        grade = "유니크",
////                        cardColor = UniqueBackgroundColor,
////                        textColor = UniqueTextColor
////                    )
////                    Spacer(modifier = Modifier.weight(1f))
////                    CardItemGrade().GradeCardView(
////                        grade = "에픽",
////                        cardColor = EpicBackgroundColor,
////                        textColor = EpicTextColor
////                    )
////                    Spacer(modifier = Modifier.weight(1f))
////                    CardItemGrade().GradeCardView(
////                        grade = "레어",
////                        cardColor = RareBackgroundColor,
////                        textColor = RareTextColor
////                    )
////                    Spacer(modifier = Modifier.weight(1f))
//                }

            }
        }

    }


    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun KotlinWorldDialog(modifier: Modifier, drawable: Drawable?) {
        var showDialog by remember { mutableStateOf(false) }


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
            Dialog(onDismissRequest = {
                showDialog = false
                viewModel.getUserData("signer001")
            }) {
                Surface(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(12.dp),
                    color = Color.White
                ) {
                    DialogContent()
                }
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ParallaxEffect(viewModel: MainViewModel, activity: MainActivity) {
        val state = rememberCollapsingToolbarScaffoldState()

        var enabled by remember { mutableStateOf(true) }
        var test by remember {
            mutableStateOf("")
        }

        LaunchedEffect(key1 = Unit) {
            viewModel.getUserData("xzI존토벤x")
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
                                .padding(12.dp)
                        )



                        Spacer(
                            modifier = Modifier.width(4.dp)
                        )

                        val textModifier = Modifier
                            .graphicsLayer {
                                alpha = (1f - state.toolbarState.progress)
                            }
                            .align(CenterVertically)

                        ToolbarNickName(name = test, textModifier)

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

                        KotlinWorldDialog(
                            modifier = Modifier,
                            drawable = activity.getDrawable(R.mipmap.search)
                        )

                    }

                    ToolbarView(viewModel = viewModel)

                }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                ) {
                    MainAvatar(viewModel = viewModel)
                }

//            LazyColumn(
//                modifier = Modifier.fillMaxSize()
//            ) {
//
//            }


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
            color = Color.White
        )
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun ToolbarView(viewModel: MainViewModel) {
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
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
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
                        Text(
                            text = temp.value!!.characterVo.level,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = temp.value!!.characterVo.world,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier
                        )

                        Spacer(modifier = Modifier.width(8.dp))
                        Divider(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .padding(0.dp, 4.dp, 0.dp, 4.dp), color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = temp.value!!.characterVo.name,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Monospace,

                            )


                    }


                }

            }

        }

    }


    @Composable
    fun MainAvatar(viewModel: MainViewModel) {
        val temp = viewModel.getData().observeAsState()
        LaunchedEffect(key1 = Unit) {
            viewModel.getUserData("xzI존토벤x")
        }
        if (temp.value != null) {
            if (temp.value?.characterVo == null) {
                return
            }
            Stats(charInfo = temp.value!!.characterVo, items = temp.value!!.items)

        }

    }

}

@Composable
fun MainInfo(viewModel: MainViewModel) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getUserData("signer001")
    }
}



