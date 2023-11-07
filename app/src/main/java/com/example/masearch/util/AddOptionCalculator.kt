package com.example.masearch.util

import android.util.Log
import com.example.masearch.api.vo.ItemsVo

// itemsVo
//"image":"https://avatar.maplestory.nexon.com/ItemIcon/KEPKJBHH.png",
//"name":"아케인셰이드 메이지글러브",
//"level":"200",
//"starforce":"17성 강화",
//"soul":"",
//"itemType":"장갑",
//"seed":"",

//스탯은  ["총합수치", "기본 아이템 스탯", "추옵", "강화또는 주문서작으로 올린 수치" ]
//"STR":["36","0","36","0"],
//"INT":["212","40","102","70"],
//"LUK":["110","40","0","70"],
//"공격력":["25","0","0","25"],
//"마력":["47","9","6","32"],
//"물리방어력":["584","250","0","334"],
//"올스탯":["5%","0%","5%"]

val strClass = listOf(
    "히어로",
    "팔라딘",
    "다크나이트",
    "소울마스터",
    "미하일",
    "블래스터",
    "데몬슬레이어",
    "아란",
    "카이저",
    "아델",
    "제로",
    "바이퍼",
    "캐논슈터",
    "스트라이커",
    "은월",
    "아크"
)
val dexClass =
    listOf("보우마스터", "신궁", "패스파인더", "윈드브레이커", "와일드헌터", "메르세데스", "카인", "캡틴", "메카닉", "엔젤릭버스터")
val intClass =
    listOf("아크메이지(불,독)", "아크메이지(썬,콜)", "비숍", "플레임위자드", "배틀메이지", "에반", "루미너스", "일리움", "라라", "키네시스")
val lukClass = listOf("나이트로드", "섀도어", "듀얼블레이드", "나이트워커", "팬텀", "카데나", "칼리", "호영")

class AddOptionCalculator {
    fun calculateAddOption(items: ItemsVo, jobClass: String): Int {
        Log.d("TAG", "calculateAddOption jobClass : $jobClass")

        var addOption = 0

        addOption = if (strClass.contains(jobClass)) {
            calculateStr(items)
        } else if (dexClass.contains(jobClass)) {
            calculateDex(items)
        } else if (intClass.contains(jobClass)) {
            calculateInt(items)
        } else if (lukClass.contains(jobClass)) {
            calculateLuk(items)
        } else {
            calculateXenon(items)
        }

        return addOption
    }


    private fun calculateStr(items: ItemsVo): Int {
        var addOption = 0
        if (items.STR != null && items.STR.size == 4) {
            addOption += Integer.parseInt(items.STR[2])
        }

        if (items.AllStat != null && items.AllStat.size > 0) {
            addOption += Integer.parseInt(items.AllStat[0].replace("%", "")) * 10
        }

        if (items.attPower != null && items.attPower.size == 4) {
            addOption += Integer.parseInt(items.attPower[2]) * 4
        }

        return addOption
    }

    private fun calculateDex(items: ItemsVo): Int {
        var addOption = 0
        if (items.DEX != null && items.DEX.size == 4) {
            addOption += Integer.parseInt(items.DEX[2])
        }

        if (items.AllStat != null && items.AllStat.size > 0) {
            addOption += Integer.parseInt(items.AllStat[0].replace("%", "")) * 10
        }

        if (items.attPower != null && items.attPower.size == 4) {
            addOption += Integer.parseInt(items.attPower[2]) * 4
        }

        return addOption
    }

    private fun calculateInt(items: ItemsVo): Int {
        var addOption = 0
        if (items.INT != null && items.INT.size == 4) {
            addOption += Integer.parseInt(items.INT[2])
        }

        if (items.AllStat != null && items.AllStat.size > 0) {
            addOption += Integer.parseInt(items.AllStat[0].replace("%", "")) * 10
        }

        if (items.spellPower != null && items.spellPower.size == 4) {
            addOption += Integer.parseInt(items.spellPower[2]) * 4
        }

        return addOption
    }

    private fun calculateLuk(items: ItemsVo): Int {
        var addOption = 0
        if (items.LUK != null && items.LUK.size == 4) {
            addOption += Integer.parseInt(items.LUK[2])
        }

        if (items.AllStat != null && items.AllStat.size > 0) {
            addOption += Integer.parseInt(items.AllStat[0].replace("%", "")) * 10
        }

        if (items.attPower != null && items.attPower.size == 4) {
            addOption += Integer.parseInt(items.attPower[2]) * 4
        }

        return addOption
    }

    private fun calculateHp(items: ItemsVo): Int {
        var addOption = 0
        if (items.STR.size == 4) {
            addOption += Integer.parseInt(items.STR[2])
        }

        if (items.AllStat.size > 0) {
            addOption += Integer.parseInt(items.AllStat[0].replace("%", "")) * 10
        }

        if (items.attPower.size == 4) {
            addOption += Integer.parseInt(items.attPower[2])
        }

        return addOption
    }

    private fun calculateXenon(items: ItemsVo): Int {
        var addOption = 0
        if (items.STR.size == 4) {
            addOption += Integer.parseInt(items.STR[2])
        }

        if (items.AllStat.size > 0) {
            addOption += Integer.parseInt(items.AllStat[0].replace("%", "")) * 10
        }

        if (items.attPower.size == 4) {
            addOption += Integer.parseInt(items.attPower[2])
        }

        return addOption
    }
}