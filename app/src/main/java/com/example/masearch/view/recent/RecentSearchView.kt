package com.example.masearch.view.recent

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.R
import com.example.masearch.api.vo.RecentSearchVO
import com.example.masearch.room.RecentSearchViewModel
import com.example.masearch.screen.Screen
import com.example.masearch.ui.theme.MainBackgroundColor
import com.example.masearch.util.noRippleClickable

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecentSearchView(navController: NavController, navigateBack: () -> Unit) {
    val recentSearchViewModel: RecentSearchViewModel = hiltViewModel()
    val recentNameList by recentSearchViewModel.recentSearchData.collectAsState()

//    LaunchedEffect(true) {
//        recentSearchViewModel.recentSearchData.value?.let {
//            recentNameList.addAll(it)
//        }
//    }

    Surface(color = MainBackgroundColor) {
        Column(modifier = Modifier.background(MainBackgroundColor)) {
            Row(modifier = Modifier.height(56.dp), verticalAlignment = Alignment.CenterVertically) {
                GlideImage(
                    model = ContextCompat.getDrawable(LocalContext.current, R.mipmap.perv_btn),
                    contentDescription = "back",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clickable(onClick = navigateBack)
                        .align(Alignment.CenterVertically)
                        .padding(12.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "최근 검색 기록", fontSize = 16.sp,
                    fontFamily = FontFamily(
                        Font(
                            R.font.notosans_bold,
                            FontWeight.Normal,
                            FontStyle.Normal
                        )
                    ),
                    color = Color.White
                )

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MainBackgroundColor)
            ) {
                recentNameList.let {
                    items(it.size) { num ->
                        RecentHolder(
                            recentSearchVO = it[num],
                            navController = navController,
                            onDeleteName = { name ->
                                recentSearchViewModel.deleteRecentName(name = name)
//                                recentNameList.removeAt(num)
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun RecentHolder(
    recentSearchVO: RecentSearchVO,
    navController: NavController,
    onDeleteName: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .noRippleClickable {
                navController.navigate(Screen.SearchScreen.searchCharacter(recentSearchVO.nickName))
            }, color = MainBackgroundColor
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${recentSearchVO.nickName}",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(8.dp, 8.dp, 0.dp, 0.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.mipmap.close),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp)
                    .noRippleClickable {
                        onDeleteName(recentSearchVO.nickName)
                    }
            )
        }
    }
}