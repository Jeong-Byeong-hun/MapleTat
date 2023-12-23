package com.example.masearch.mainui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.R
import com.example.masearch.ui.theme.LikeBackgroundColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LikeCharacterHolder(index : Int) {

    Surface(
        modifier = Modifier
            .width(120.dp)
            .height(150.dp)
            .clickable {
                Log.d("TAG", "LikeCharacterHolder: click $index")
            }, color = LikeBackgroundColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            GlideImage(
                model = "https://open.api.nexon.com/static/maplestory/ItemIcon/KEPCJGME.png",
                contentDescription = "serverIcon",
                modifier = Modifier
                    .width(14.dp)
                    .height(14.dp)
            )

            GlideImage(
                model = "https://open.api.nexon.com/static/maplestory/Character/MBOPMFBPDMIMILJBMAINHCNCDBNHHJDJBBHNOLBJFHLKMLLLMBCIFOMGKFJPONMNOFKGKOGLMJGOCLDGALLKABBJLHEIDAGCGKCELMOMEDLDNMMADJOMCNFNJLHHJBFJPKFPHDNPHKBKFEHDGFILJPGKIJGIDMMDFBMANNBLHBGIEDMNFINPELOKKAGMPHLLEGNEHGEHHKLAAEIAEEFBDBCIOJNINMBCNOJCBJGFBDPCJDPAOAHHMLIKHNGOCKJJ.png",
                contentDescription = "charImg",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Lv.278 xzI존토벤x",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
            )
        }

    }
}

@Preview
@Composable
fun previewLikeCharacter() {
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp),
    ){
        items(10) {
            LikeCharacterHolder(it)
        }
    }
}