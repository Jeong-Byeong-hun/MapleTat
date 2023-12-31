package com.example.masearch.view.stat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
import com.example.masearch.api.vo.AbilityVO
import com.example.masearch.api.vo.FinalStatVO
import com.example.masearch.ui.theme.EtcStatBackgroundColor

@Composable
fun EtcStatView(finalStatList: List<FinalStatVO>, abilityVO: AbilityVO){
    val attackPowerList = listOf<String>("공격력","마력")
    val recycleStatList = listOf<String>("재사용 대기시간 감소")
    val etcStatList = listOf<String>( "재사용 대기시간 미적용", "버프 지속시간","속성 내성 무시", "일반 몬스터 데미지", "메소 획득량", "아이템 드롭률" )
    val forceList = listOf<String>("아케인포스", "어센틱포스")

    Surface( color = EtcStatBackgroundColor, shape = RoundedCornerShape(5.dp)) {

        Column(modifier = Modifier
            .width(200.dp)
            .padding(6.dp, 6.dp, 6.dp, 2.dp)) {
            for (i in attackPowerList){
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
            for ((index, value) in recycleStatList.withIndex()){
                when(index){
                    0-> {
                        var secondValue = ""
                        var percentValue = ""
                        val recycleTempList = finalStatList.filter { it.statName.contains(value) }

                        if (recycleStatList.isNotEmpty()){
                            secondValue = recycleTempList[0].statValue.toString()
                            percentValue = recycleTempList[1].statValue.toString()
                            RecycleStatTextView(secondValue = secondValue, percentValue = percentValue)
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }

                }
            }

            for (i in etcStatList){
                val foundStat = finalStatList.find { finalStatVO -> finalStatVO.statName == i }
                if (foundStat != null) {
                    foundStat.statValue?.let { statValue ->
                        PercentStatTextView(
                            statType = i,
                            num = statValue
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }

            for (i in forceList){
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

            AbilityStatView(abilityVO = abilityVO)


        }
    }
}

@Composable
fun RecycleStatTextView(secondValue : String, percentValue: String) {
    Row {
        Text(
            text = "재사용 대기시간 감소 :", color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${secondValue}초 / ${percentValue}%", color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
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
fun PercentStatTextView(statType: String, num: String) {
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
            text = "${num}%", color = Color.White, fontSize = 12.sp, fontFamily = FontFamily(
                Font(
                    R.font.gmarket_sans_medium,
                    FontWeight.Normal,
                    FontStyle.Normal
                )
            )
        )
    }
}
