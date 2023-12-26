package com.example.masearch.view.stat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masearch.R
import com.example.masearch.api.vo.FinalStatVO
import com.example.masearch.ui.theme.SpecialDamageBackgroundColor
import com.example.masearch.util.convertToCombatPower

@Composable
fun SpecialStatView(finalStatList: List<FinalStatVO>, modifier: Modifier) {
    val basicStat =
        listOf<String>("데미지", "보스 몬스터 데미지", "최종 데미지", "크리티컬 데미지", "상태이상 추가 데미지")
    Surface(
        color = SpecialDamageBackgroundColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = modifier
        ) {
            val foundStat =
                finalStatList.find { finalStatVO -> finalStatVO.statName == "최대 스탯공격력" }
            if (foundStat != null) {
                foundStat.statValue?.let {
                    CombatPowerTextView(statType = "스탯 공격력", num = it)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }

            for (i in basicStat) {
                val foundStat2 = finalStatList.find { finalStatVO -> finalStatVO.statName == i }
                if (foundStat2 != null) {
                    foundStat2.statValue?.let { statValue ->
                        SpecialStatTextView(
                            statType = i,
                            num = statValue
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun SpecialStatTextView(statType: String, num: String) {
    Row {
        Text(
            text = "$statType :", color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$num%", color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
    }
}

@Composable
fun CombatPowerTextView(statType: String, num: String) {
    Row {
        Text(
            text = "$statType :", color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = convertToCombatPower(num),
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

}