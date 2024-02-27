package com.example.masearch.view.stat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masearch.R
import com.example.masearch.api.vo.HyperStatVO
import com.example.masearch.ui.theme.HyperStatBackgroundColor
import com.example.masearch.ui.theme.HyperStatLevelColor
import com.example.masearch.ui.theme.HyperStatSelectBoxColor
import com.example.masearch.ui.theme.HyperStatUnSelectBoxColor

@Composable
fun HyperStatView(modifier: Modifier, hyperStat: HyperStatVO) {
    var selectedButton = hyperStat.usePresetNum.toInt()

    Surface(color = HyperStatBackgroundColor, shape = RoundedCornerShape(5.dp)) {
        Column(modifier = modifier) {
            val selectHyperStat = when (selectedButton) {
                1 -> hyperStat.hyperStatFirst
                2 -> hyperStat.hyperStatSecond
                3 -> hyperStat.hyperStatThird
                else -> emptyList()
            }
            Text(
                text = "현재 적용중인 하이퍼 스탯 ${hyperStat.usePresetNum}번",
                color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                    Font(
                        R.font.gmarket_sans_medium,
                        FontWeight.Normal,
                        FontStyle.Normal
                    )
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            for (i in selectHyperStat) {
                if (i.statLevel > 0) {
                    i.statIncrease?.let {
                        HyperStatTextView(
                            level = i.statLevel,
                            statIncrease = it
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
            ) {
                NumberButton(1, selectedButton == 1) { selectedButton = 1 }
                Spacer(modifier = Modifier.width(6.dp))

                NumberButton(2, selectedButton == 2) { selectedButton = 2 }

                Spacer(modifier = Modifier.width(6.dp))
                NumberButton(3, selectedButton == 3) { selectedButton = 3 }

            }
        }
    }
}


@Composable
fun HyperStatTextView(level: Int, statIncrease: String) {
    Text(
        text = "Lv.$level",
        modifier = Modifier
            .background(
                color = HyperStatLevelColor,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(4.dp, 1.dp, 4.dp, 1.dp),
        color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
            Font(
                R.font.gmarket_sans_medium,
                FontWeight.Normal,
                FontStyle.Normal
            )
        )
    )

    Spacer(modifier = Modifier.width(4.dp))

    Text(
        text = "$statIncrease",
        color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
            Font(
                R.font.gmarket_sans_medium,
                FontWeight.Normal,
                FontStyle.Normal
            )
        )
    )

}

@Composable
fun NumberButton(number: Int, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(5.dp))
            .size(20.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isSelected) HyperStatSelectBoxColor else HyperStatUnSelectBoxColor),
        contentPadding = PaddingValues(2.dp, 1.dp)
    ) {
        Text(
            text = "$number",
            color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
    }
}