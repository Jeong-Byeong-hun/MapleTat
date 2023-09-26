package com.example.masearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DialogContent() {
    Column {
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
        Text(
            "닉네임을 검색해주세요.",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(vertical = 8.dp),
            fontSize = 16.sp,
            lineHeight = 17.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontFamily = FontFamily(
                Font(
                    R.font.notosans_regular,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = {

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                "검색하기",
                fontSize = 16.sp,
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
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
    }
}