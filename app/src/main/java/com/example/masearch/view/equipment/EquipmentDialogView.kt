package com.example.masearch.view.equipment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.R
import com.example.masearch.api.vo.ItemEquipmentDetailVO
import com.example.masearch.ui.theme.EquipmentDialogBackgroundColor
import com.example.masearch.ui.theme.ItemAddOptionColor
import com.example.masearch.ui.theme.ItemDetailBackgroundColor
import com.example.masearch.ui.theme.ItemEtcOptionColor
import com.example.masearch.ui.theme.ItemStarForceOptionColor
import com.example.masearch.ui.theme.StarForceIconColor

//item: ItemEquipmentDetailVO
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun EquipmentDialogView(item: ItemEquipmentDetailVO) {
    val context = LocalContext.current
    val addOptionList = listOf<String>(
        "STR",
        "DEX",
        "INT",
        "LUK",
        "MaxHp",
        "MaxMp",
        "공격력",
        "마력",
    )
    val addOptionPercentList =
        listOf<String>("보스 공격 시 데미지", "방어력 무시", "올스탯", "데미지", "최대 HP (%)")


    Surface(color = EquipmentDialogBackgroundColor, shape = RoundedCornerShape(5.dp)) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .width(400.dp)
                .wrapContentHeight()
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GlideImage(
                        model = ContextCompat.getDrawable(context, R.mipmap.star_full),
                        contentDescription = "start",
                        modifier = Modifier
                            .height(14.dp)
                            .width(14.dp),
                        colorFilter = ColorFilter.tint(StarForceIconColor)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "22성", color = Color.Yellow)
                }

                Text(text = "${item.itemName}", color = Color.White)
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    modifier = Modifier.size(90.dp),
                    color = ItemDetailBackgroundColor,
                    shape = RoundedCornerShape(5.dp)
                ) {
                    GlideImage(
                        model = item.itemIcon,
                        contentDescription = "start",
                        modifier = Modifier.padding(12.dp),
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "장비분류 : ${item.itemSlot}", color = Color.White)
                val allValues = mutableListOf<String>()
                val percentValues = mutableListOf<String>()

                listOf(
                    item.itemTotalOption,
                    item.itemBaseOption,
                    item.itemAddOption,
                    item.itemEtcOption,
                    item.itemStarforceOption
                ).forEach { option ->
                    allValues.addAll(
                        listOf(
                            option.str,
                            option.dex,
                            option.int,
                            option.luk,
                            option.maxHp,
                            option.maxHp,
                            option.attackPower,
                            option.magicPower
                        )
                    )
                }

                listOf(
                    item.itemTotalOption,
                    item.itemBaseOption,
                    item.itemAddOption,
                ).forEach { option ->
                    percentValues.addAll(
                        listOf(
                            option.bossDamage,
                            option.ignoreMonsterArmor,
                            option.allStat,
                            option.damage,
                            option.maxHpRate,
                        )
                    )
                }

                Log.d("TAG", "EquipmentDialogView: $percentValues")

                for ((i, property) in addOptionList.withIndex()) {
                    StyledText(
                        statProperty = property,
                        totalStat = allValues[i],
                        baseStat = allValues[i + 8],
                        addStat = allValues[i + 16],
                        etcStat = allValues[i + 24],
                        starForceStat = allValues[i + 32]
                    )
                }

                for ((i, property) in addOptionPercentList.withIndex()) {
                    StyledPercentText(
                        statProperty = property,
                        totalStat = percentValues[i],
                        baseStat = (percentValues[i + 5] ?: "0"),
                        addStat = (percentValues[i + 10] ?: "0")
                    )
                }
            }

            

        }


    }

}

@Composable
fun StyledText(
    statProperty: String,
    totalStat: String,
    baseStat: String,
    addStat: String,
    etcStat: String,
    starForceStat: String,
) {

    val text = buildAnnotatedString {
        if (totalStat.toInt() > 0) {
            withStyle(style = SpanStyle(color = Color.White)) {
                append("$statProperty : $totalStat")
                if (totalStat.toInt() != baseStat.toInt()) {
                    append("(${baseStat}")
                }
            }
        }

        if (addStat.toInt() > 0) {
            withStyle(style = SpanStyle(color = ItemAddOptionColor)) {
                append(" +${addStat}")
            }
        }

        if (etcStat.toInt() > 0) {
            withStyle(style = SpanStyle(color = ItemEtcOptionColor)) {
                append(" +${etcStat}")
            }
        }

        if (starForceStat.toInt() > 0) {
            withStyle(style = SpanStyle(color = ItemStarForceOptionColor)) {
                append(" +${starForceStat}")
            }
        }

        if (totalStat.toInt() != baseStat.toInt()) {
            withStyle(style = SpanStyle(color = Color.White)) {
                append(")")
            }
        }

    }

    if (text.isNotEmpty()) {
        Text(text = text)
    }
}

@Composable
fun StyledPercentText(
    statProperty: String,
    totalStat: String,
    baseStat: String,
    addStat: String,
) {

    val text = buildAnnotatedString {
        if (totalStat.toInt() > 0) {
            withStyle(style = SpanStyle(color = Color.White)) {
                append("$statProperty : $totalStat%")
                if (totalStat.toInt() != baseStat.toInt()) {
                    append("(${baseStat}%")
                }
            }
        }

        if (addStat.toInt() > 0) {
            withStyle(style = SpanStyle(color = ItemAddOptionColor)) {
                append(" +${addStat}%")
            }
        }

        if (totalStat.toInt() != baseStat.toInt()) {
            withStyle(style = SpanStyle(color = Color.White)) {
                append(")")
            }
        }

    }

    if (text.isNotEmpty()) {
        Text(text = text)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
@Preview
fun PreviewEquip() {
//    EquipmentDialogView()
}