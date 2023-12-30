package com.example.masearch.util

import com.example.masearch.api.vo.ItemEquipmentDetailVO
import android.util.Log

fun equipmentSort(equipList: List<ItemEquipmentDetailVO>): List<ItemEquipmentDetailVO> {
    var newEquipmentList: List<ItemEquipmentDetailVO> = mutableListOf()
    val sortStandard = listOf<String>(
        "무기",
        "엠블렘",
        "보조무기",
        "모자",
        "상의",
        "하의",
        "망토",
        "장갑",
        "신발",
        "어깨장식",
        "벨트",
        "귀고리",
        "반지1",
        "반지2",
        "반지3",
        "반지4",
        "펜던트",
        "펜던트2",
        "눈장식",
        "얼굴장식",
        "기계 심장",
        "포켓 아이템",
        "훈장",
        "뱃지",
    )
    newEquipmentList = equipList.sortedBy { sortStandard.indexOf(it.itemSlot)}

    return newEquipmentList
}