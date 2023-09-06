package com.example.masearch.mainui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class CardItemGrade {

    @Composable
    fun GradeCardView(grade: String, cardColor: Color, textColor : Color) {
        Card(
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(cardColor)
        ) {
            Column(
                modifier = Modifier
                    .height(22.dp)
                    .padding(4.dp, 3.dp, 4.dp, 3.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = grade, modifier = Modifier, color = textColor, fontSize = 13.sp)
            }
        }
    }
}