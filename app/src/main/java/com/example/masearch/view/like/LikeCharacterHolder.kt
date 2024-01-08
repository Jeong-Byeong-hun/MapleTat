package com.example.masearch.view.like

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.masearch.LikeCharacterViewModel
import com.example.masearch.R
import com.example.masearch.api.vo.LikeCharacterVo
import com.example.masearch.screen.Screen
import com.example.masearch.ui.theme.LikeBackgroundColor
import com.example.masearch.ui.theme.MainBackgroundColor
import com.example.masearch.util.noRippleClickable

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LikeCharacterHolder(likeCharacterVo: LikeCharacterVo, navController: NavController) {

    Surface(
        modifier = Modifier
            .width(120.dp)
            .height(150.dp)
            .noRippleClickable {
                navController.navigate(Screen.SearchScreen.searchCharacter(likeCharacterVo.nickName))
            }, color = LikeBackgroundColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
//            GlideImage(
//                model = "https://open.api.nexon.com/static/maplestory/ItemIcon/KEPCJGME.png",
//                contentDescription = "serverIcon",
//                modifier = Modifier
//                    .width(14.dp)
//                    .height(14.dp)
//            )

            GlideImage(
                model = likeCharacterVo.imgUrl,
                contentDescription = "charImg",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Lv.${likeCharacterVo.level} ${likeCharacterVo.nickName}",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
            )
        }

    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LikeCharacterView(navController: NavController, navigateBack: () -> Unit) {
    val likeCharacterViewModel: LikeCharacterViewModel = hiltViewModel()
    val context = LocalContext.current

    likeCharacterViewModel.getAllList()

    Surface {
        Column(modifier = Modifier.background(MainBackgroundColor)) {
            Row(modifier = Modifier.height(56.dp), verticalAlignment = Alignment.CenterVertically) {
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
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "즐겨찾기", fontSize = 16.sp,
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

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                likeCharacterViewModel.characterData.value?.let {
                    items(it.size) { num ->
                        LikeCharacterHolder(
                            likeCharacterVo = it[num],
                            navController = navController
                        )
                    }
                }
            }
        }

    }

}