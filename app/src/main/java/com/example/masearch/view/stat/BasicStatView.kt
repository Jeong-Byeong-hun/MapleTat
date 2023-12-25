package com.example.masearch.view.stat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masearch.R
import com.example.masearch.api.vo.FinalStatVO
import com.example.masearch.ui.theme.StatBackgroundColor
import com.example.masearch.util.addCommas

@Composable
fun BasicStatView(finalStatList: List<FinalStatVO>) {
    val basicStat = listOf<String>("HP", "MP", "STR", "DEX", "INT", "LUK")

    Surface(
        color = StatBackgroundColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier.width(114.dp).padding(6.dp,6.dp,6.dp,2.dp)) {
            for (i in basicStat){
                val foundStat = finalStatList.find { finalStatVO -> finalStatVO.statName == i }
                if (foundStat != null) {
                    foundStat.statValue?.let { statValue ->
                        BasicStatTextView(
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
fun BasicStatTextView(statType: String, num: String) {
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
            text = addCommas(num), color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
    }
}