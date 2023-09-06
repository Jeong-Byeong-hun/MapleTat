package com.example.masearch

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.api.vo.CharacterVo
import com.example.masearch.api.vo.Items
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Stats(charInfo: CharacterVo, items: MutableList<Items>) {

    val tabData = listOf(
        "기본정보",
        "장비템"
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val tabIndex = pagerState.currentPage
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        tabData.forEachIndexed() { index, text ->
            Tab(modifier = Modifier.background(Color.DarkGray),
                selected = tabIndex == index,
                onClick = {
                    coroutineScope.launch {
                        Log.d("stats", "Stats: " + tabIndex)
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = text)
                })

        }
    }


    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent), count = 2,
        state = pagerState
    ) {
        when (it) {
            0 -> BasicInfo(charInfo = charInfo)

            1 -> EquipmentList(items = items)
//                Text(
//                modifier = Modifier.wrapContentSize(),
//                text = it.toString(),
//                textAlign = TextAlign.Center,
//                fontSize = 30.sp
//            )
        }

    }

}

@Composable
fun BasicInfo(charInfo: CharacterVo) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .padding(0.dp, 0.dp, 0.dp, 30.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(16.dp)
                .width(120.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Yellow)
                .wrapContentSize(Alignment.Center)

        ) {
            Text(
                text = "기본 스탯",
                color = Color.Black,
                fontSize = 24.sp
            )
        }


        Text(
            text = "STR : ${charInfo.str}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        Text(
            text = "DEX : ${charInfo.dex}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        Text(
            text = "INT : ${charInfo.int}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        Text(
            text = "LUK : ${charInfo.luk}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp, 0.dp, 0.dp),
            color = Color.DarkGray,
            thickness = 1.dp
        )

        Text(
            text = "스탯공격력 : ${charInfo.statAttPower[0]} ~ ${charInfo.statAttPower[1]}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)

        )
        Text(
            text = "크리티컬 데미지 : ${charInfo.criticalDamage}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        Text(
            text = "보스공격력 : ${charInfo.boseOffensePower}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        Text(
            text = "방어율무시 : ${charInfo.ignoreDefense}",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp, 0.dp, 0.dp),
            color = Color.DarkGray,
            thickness = 1.dp
        )

        Text(
            text = "${charInfo.ability.grade} 어빌리티",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        for (i: String in charInfo.ability.value) {
            Text(
                text = i,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp, 0.dp, 0.dp),
            color = Color.DarkGray,
            thickness = 1.dp
        )

        Text(
            text = "하이퍼 스탯",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
        )
        for (i: String in charInfo.hyperStats) {
            Text(
                text = i,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 0.dp)
            )
        }

    }

}

@Composable
fun EquipmentList(items: MutableList<Items>) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .padding(0.dp, 0.dp, 0.dp, 30.dp)
    ) {
        for (item in items) {
            Equipment(items = item)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Equipment(items: Items) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp, 16.dp, 0.dp)
    ) {
        GlideImage(
            model = items.image, contentDescription = items.name, modifier = Modifier
                .height(50.dp)
                .width(50.dp),
            alignment = Alignment.CenterStart
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp, 0.dp, 0.dp)) {
            Text(text = items.name)
        }
    }

}