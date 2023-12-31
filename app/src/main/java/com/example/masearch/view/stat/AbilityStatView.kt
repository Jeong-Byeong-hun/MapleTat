package com.example.masearch.view.stat

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masearch.R
import com.example.masearch.api.vo.AbilityVO
import com.example.masearch.ui.theme.ItemDetailEpicTextColor
import com.example.masearch.ui.theme.ItemDetailLegendaryTextColor
import com.example.masearch.ui.theme.ItemDetailRareTextColor
import com.example.masearch.ui.theme.ItemDetailUniqueTextColor

@Composable
fun AbilityStatView(abilityVO: AbilityVO) {
    val abilityTitle = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                    Font(
                        R.font.gmarket_sans_medium,
                        FontWeight.Normal,
                        FontStyle.Normal
                    )
                )
            )
        ) {
            append("어빌리티 등급 : ")
        }

        abilityVO.grade.let {
            val color = when (abilityVO.grade) {
                "레전드리" -> ItemDetailLegendaryTextColor
                "유니크" -> ItemDetailUniqueTextColor
                "에픽" -> ItemDetailEpicTextColor
                "레어" -> ItemDetailRareTextColor
                else -> Color.Transparent
            }

            withStyle(
                style = SpanStyle(
                    color = color, fontSize = 12.sp, fontFamily = FontFamily(
                        Font(
                            R.font.gmarket_sans_medium,
                            FontWeight.Normal,
                            FontStyle.Normal
                        )
                    )
                )
            ) {
                append("${abilityVO.grade}")
            }
        }

    }

    Text(text = abilityTitle)

    for (ability in abilityVO.info) {
        val color = when (ability.abilityGrade) {
            "레전드리" -> ItemDetailLegendaryTextColor
            "유니크" -> ItemDetailUniqueTextColor
            "에픽" -> ItemDetailEpicTextColor
            "레어" -> ItemDetailRareTextColor
            else -> Color.Transparent
        }
        AbilityStatTextView(text = ability.abilityValue, color)
    }

}


@Composable
fun AbilityStatTextView(text: String, color: Color = Color.White) {
    Row {
        Text(
            text = "$text", color = color, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
    }
}