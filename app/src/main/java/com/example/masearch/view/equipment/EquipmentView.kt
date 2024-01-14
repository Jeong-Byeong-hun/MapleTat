package com.example.masearch.view.equipment

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.masearch.BasicEquipmentTextview
import com.example.masearch.api.vo.ItemEquipmentDetailVO
import com.example.masearch.api.vo.ItemEquipmentVO
import com.example.masearch.api.vo.TitleVO
import com.example.masearch.ui.theme.DividerColor
import com.example.masearch.ui.theme.EpicBackgroundColor
import com.example.masearch.ui.theme.LegendaryBackgroundColor
import com.example.masearch.ui.theme.RareBackgroundColor
import com.example.masearch.ui.theme.UniqueBackgroundColor
import com.example.masearch.util.AddOptionCalculator
import com.example.masearch.util.convertTime
import com.example.masearch.util.equipmentSort
import com.example.masearch.util.noRippleClickable

@Composable
fun EquipmentList(equipment: ItemEquipmentVO, jobClass: String) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(equipmentSort(equipList = equipment.itemEquipmentList)) { index, item ->
            Equipment(itemsVo = item, jobClass)
            Spacer(modifier = Modifier.height(8.dp))
            Divider(thickness = 1.dp, color = DividerColor)

            if (equipment.itemEquipmentList.size - 1 == index) {
                equipment.title?.let { it1 -> EquipmentTitle(title = it1) }
            }
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Equipment(itemsVo: ItemEquipmentDetailVO, jobClass: String) {
    var dialogState by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp, 16.dp, 0.dp)
            .noRippleClickable {
                dialogState = true
            }
    ) {
        GlideImage(
            model = itemsVo.itemIcon, contentDescription = itemsVo.itemName,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.CenterVertically),
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Row {
                BasicEquipmentTextview(text = itemsVo.itemName)
                Spacer(modifier = Modifier.width(6.dp))
                if (itemsVo.starforce != "0") {
                    BasicEquipmentTextview(text = "${itemsVo.starforce}성")
                }
                Spacer(modifier = Modifier.width(4.dp))

                //todo 추옵설정
                if (itemsVo.itemSlot == "무기") {

                    BasicEquipmentTextview(
                        text = AddOptionCalculator().getWeaponAddOption(
                            itemBaseOption = itemsVo.itemBaseOption,
                            itemAddOption = itemsVo.itemAddOption,
                            jobClass = jobClass,
                            itemLevel = itemsVo.itemBaseOption.baseEquipmentLevel
                        ).toString()
                    )
                } else {
                    BasicEquipmentTextview(
                        text = AddOptionCalculator().getAddOption(
                            itemBaseOption = itemsVo.itemBaseOption,
                            itemAddOption = itemsVo.itemAddOption,
                            jobClass = jobClass,
                            itemName = itemsVo.itemName
                        )
                    )
                }
            }

            Column {
                Spacer(modifier = Modifier.width(8.dp))
                itemsVo.potentialOptionGrade?.let {
                    val color =
                        when (itemsVo.potentialOptionGrade) {
                            "레어" -> RareBackgroundColor
                            "에픽" -> EpicBackgroundColor
                            "유니크" -> UniqueBackgroundColor
                            "레전드리" -> LegendaryBackgroundColor
                            else -> Color.Transparent
                        }

                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        color = color
                    ) {
                        Row(
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .padding(2.dp, 1.dp, 2.dp, 1.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
//                            BasicEquipmentTextview(text = itemsVo.potentialOptionGrade)
                            itemsVo.potentialOption1?.let { it1 -> PotentialText(potential = it1) }
                            itemsVo.potentialOption2?.let { it1 -> PotentialText(potential = it1) }
                            itemsVo.potentialOption3?.let { it1 -> PotentialText(potential = it1) }
                        }
                    }
                }



                Spacer(modifier = Modifier.height(8.dp))
                itemsVo.additionalPotentialOptionGrade?.let {
                    val addColor = when (itemsVo.additionalPotentialOptionGrade) {
                        "레어" -> RareBackgroundColor
                        "에픽" -> EpicBackgroundColor
                        "유니크" -> UniqueBackgroundColor
                        "레전드리" -> LegendaryBackgroundColor
                        else -> Color.Transparent
                    }

                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        color = addColor
                    ) {
                        Row(
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .padding(2.dp, 1.dp, 2.dp, 1.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
//                            BasicEquipmentTextview(text = itemsVo.potentialOptionGrade)
                            itemsVo.additionalPotentialOption1?.let { it1 -> PotentialText(potential = it1) }
                            itemsVo.additionalPotentialOption2?.let { it1 -> PotentialText(potential = it1) }
                            itemsVo.additionalPotentialOption3?.let { it1 -> PotentialText(potential = it1) }
                        }
                    }

                }

            }
        }
    }

    if (dialogState) {
        EquipmentDialogView(item = itemsVo) { dialogState = false }
    }
}

@Composable
fun PotentialText(potential: String) {
//    val uselessList = listOf<String>("공격 시", "피격", "쓸만한", "HP 회복", "반사", "MP 소모")
    val potentialText = when {
        potential.contains("몬스터 방어율 무시") -> potential.replace("몬스터 방어율 무시", "방무")
        potential.contains("보스 몬스터 공격 시 데미지") -> potential.replace("보스 몬스터 공격 시 데미지", "보공")
        potential.contains("메소 획득량") -> potential.replace("메소 획득량", "메획")
        potential.contains("아이템 드롭률") -> potential.replace("아이템 드롭률", "아획")
        potential.contains("모든 스킬의 재사용 대기시간") -> potential.replace("모든 스킬의 재사용 대기시간", "쿨감")
        potential.contains("크리티컬 데미지") -> potential.replace("크리티컬 데미지", "크뎀")
        potential.contains("캐릭터 기준 9레벨 당") -> potential.replace("캐릭터 기준 9레벨 당", "렙당")
        potential.contains("공격 시") -> ""
        potential.contains("피격") -> ""
        potential.contains("쓸만한") -> ""
        potential.contains("HP 회복") -> ""
        potential.contains("반사") -> ""
        potential.contains("MP 소모") -> ""
        else -> potential
    }

    if (potentialText.isEmpty()) {
        return
    }

    if (potentialText.contains("쿨감")) {
        BasicEquipmentTextview(
            text = "${potentialText.substring(0, 8)} "
        )
    } else {
        BasicEquipmentTextview(text = "$potentialText")
    }
    Spacer(modifier = Modifier.width(6.dp))
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun EquipmentTitle(title: TitleVO) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp, 16.dp, 0.dp)
    ) {
        GlideImage(
            model = title.titleIcon, contentDescription = title.titleName,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.CenterVertically),
            alignment = Alignment.Center
        )

//        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 0.dp, 0.dp)
        ) {
            BasicEquipmentTextview(text = title.titleName)

            Spacer(modifier = Modifier.height(6.dp))
            val optionList = title.titleDescription.split("\\n")
            for (i in optionList) {
                Log.d("TAG", "EquipmentTitle: " + i)
            }
            BasicEquipmentTextview(text = title.titleDescription.replace("\n", ""))

            Spacer(modifier = Modifier.height(6.dp))

            title.dateOptionExpire?.let {
                if (title.dateOptionExpire != "expired") {
                    BasicEquipmentTextview(text = convertTime(title.dateOptionExpire))
                }
            }
        }
    }
}