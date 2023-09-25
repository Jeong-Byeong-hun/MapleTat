package com.example.masearch.util

import android.util.Log
import com.example.masearch.api.vo.ItemsVo

class ItemSort {
    private val magePotentialList = mutableListOf<String>(
        "STR",
        "DEX",
        "INT",
        "LUK",
        "최대 HP",
        "올스탯",
        "모든 스킬의 재사용 대기시간",
        "크리티컬 데미지",
        "공격력",
        "마력",
        "데미지",
        "몬스터 방어율 무시",
        "보스 몬스터 공격 시 데미지",
        "메소 획득량",
        "아이템 드롭률"
    )

    private val attackPotentialList = mutableListOf<String>(
        "STR",
        "DEX",
        "LUK",
        "최대 HP",
        "올스탯",
        "모든 스킬의 재사용 대기시간",
        "공격력",
        "데미지",
        "몬스터 방어율 무시",
        "보스 몬스터 공격 시 데미지",
        "메소 획득량",
        "아이템 드롭률"
    )

    fun integrateAdditionalPotential(itemList: MutableList<ItemsVo>): MutableList<ItemsVo> {
        itemList.forEachIndexed { index, item ->

            item.additionalPotential.option.removeIf {
                item.additionalPotential.grade == ""
            }

            for (pValue in item.additionalPotential.option) {
                if (pValue is ArrayList<*>) {
                    pValue.removeIf {
                        !magePotentialList.contains(pValue[0])
                    }

                    if (pValue.size > 1) {
                        pValue.removeIf {
                            !pValue[1].toString().contains("%") and !pValue[1].toString()
                                .contains("초")
                        }
                    }
                }
            }

            item.additionalPotential.option.removeIf {
                it is String
            }

            item.additionalPotential.option as ArrayList<ArrayList<String>>
            item.additionalPotential.option.removeIf {
                it.size == 0
            }

            val tempOptionList = ArrayList<ArrayList<String>>()


            for (option in item.additionalPotential.option) {

                val iterator = tempOptionList.listIterator()
                var isContain = true

                for ((i, value) in iterator.withIndex()) {
                    if (value.contains(option[0])) {
                        isContain = false

                        var findIndex = 0
                        tempOptionList.forEachIndexed { index, it ->
                            if (it.contains(option[0])) {
                                findIndex = index
                            }
                        }

                        val tempOption = arrayListOf<String>()
                        tempOption.add(option[0])
                        tempOption.add(
                            "+" + (value[1].replace("+", "").replace("%", "")
                                .toInt() + option[1].replace("+", "").replace("%", "")
                                .toInt()) + "%"
                        )
                        tempOptionList[findIndex] = tempOption
                    }

                }

                if ((tempOptionList.size == 0 && option.size > 1) or isContain) {
                    tempOptionList.add(option)
                }

            }

            item.additionalPotential.option.clear()
            if (tempOptionList.size > 0) {
                item.additionalPotential.option.addAll(tempOptionList)
            }

            Log.d("TAG", "additionalPotential tempOption : " + tempOptionList)

        }

        return itemList
    }
    fun integratePotential(itemList: MutableList<ItemsVo>): MutableList<ItemsVo> {

        itemList.forEachIndexed { index, item ->

            item.potential.option.removeIf {
                item.potential.grade == ""
            }

            for (pValue in item.potential.option) {
                if (pValue is ArrayList<*>) {
                    pValue.removeIf {
                        !magePotentialList.contains(pValue[0])
                    }

                    if (pValue.size > 1) {
                        pValue.removeIf {
                            !pValue[1].toString().contains("%") and !pValue[1].toString()
                                .contains("초")
                        }
                    }
                }
            }

            item.potential.option.removeIf {
                it is String
            }

            item.potential.option as ArrayList<ArrayList<String>>
            item.potential.option.removeIf {
                it.size == 0
            }

            val tempOptionList = ArrayList<ArrayList<String>>()


            for (option in item.potential.option) {

                val iterator = tempOptionList.listIterator()
                var isContain = true

                for ((i, value) in iterator.withIndex()) {
                    if (value.contains(option[0])) {
                        isContain = false

                        var findIndex = 0
                        tempOptionList.forEachIndexed { index, it ->
                            if (it.contains(option[0])) {
                                findIndex = index
                            }
                        }

                        val tempOption = arrayListOf<String>()
                        tempOption.add(option[0])
                        tempOption.add(
                            "+" + (value[1].replace("+", "").replace("%", "")
                                .toInt() + option[1].replace("+", "").replace("%", "")
                                .toInt()) + "%"
                        )
                        tempOptionList[findIndex] = tempOption
                    }

                }

                if ((tempOptionList.size == 0 && option.size > 1) or isContain) {
                    tempOptionList.add(option)
                }

            }

            item.potential.option.clear()
            if (tempOptionList.size > 0) {
                item.potential.option.addAll(tempOptionList)
            }

            Log.d("TAG", "integratePotential tempOption : " + tempOptionList)

        }

        itemList.forEachIndexed { index, item ->

            item.additionalPotential.option.removeIf {
                item.additionalPotential.grade == ""
            }

            for (pValue in item.additionalPotential.option) {
                if (pValue is ArrayList<*>) {
                    pValue.removeIf {
                        !magePotentialList.contains(pValue[0])
                    }

//                    if (pValue.size > 1) {
//                        pValue.removeIf {
//                            !pValue[1].toString().contains("%") and !pValue[1].toString()
//                                .contains("초")
//                        }
//                    }
                }
            }

            item.additionalPotential.option.removeIf {
                it is String
            }

            item.additionalPotential.option as ArrayList<ArrayList<String>>
            item.additionalPotential.option.removeIf {
                it.size == 0
            }

//            val tempOptionList = ArrayList<ArrayList<String>>()
//
//
//            for (option in item.additionalPotential.option) {
//
//                val iterator = tempOptionList.listIterator()
//                var isContain = true
//
//                for ((i, value) in iterator.withIndex()) {
//                    if (value.contains(option[0])) {
//                        isContain = false
//
//                        var findIndex = 0
//                        tempOptionList.forEachIndexed { index, it ->
//                            if (it.contains(option[0])) {
//                                findIndex = index
//                            }
//                        }
//
//                        val tempOption = arrayListOf<String>()
//                        tempOption.add(option[0])
//                        tempOption.add(
//                            "+" + (value[1].replace("+", "").replace("%", "")
//                                .toInt() + option[1].replace("+", "").replace("%", "")
//                                .toInt()) + "%"
//                        )
//                        tempOptionList[findIndex] = tempOption
//                    }
//
//                }
//
//                if ((tempOptionList.size == 0 && option.size > 1) or isContain) {
//                    tempOptionList.add(option)
//                }
//
//            }
//
//            item.additionalPotential.option.clear()
//            if (tempOptionList.size > 0) {
//                item.additionalPotential.option.addAll(tempOptionList)
//            }

//            Log.d("TAG", "additionalPotential tempOption : " + tempOptionList)

        }


        return itemList
//        for (item in itemList) {
//            Log.d("TAG", "integratePotential: " + item.potential.option)
//        }
    }

    fun sortItemList(itemList: MutableList<ItemsVo>): MutableList<ItemsVo> {
        val sortItemList = mutableListOf<ItemsVo>()
        //무보엠
        sortItemList.add(itemList[13])
        sortItemList.add(itemList[16])
        sortItemList.add(itemList[2])

        //카루타 or 에테
        sortItemList.add(itemList[1])
        sortItemList.add(itemList[14])
        sortItemList.add(itemList[19])

        //무기제외 4셋
        sortItemList.add(itemList[15])
        sortItemList.add(itemList[20])
        sortItemList.add(itemList[21])
        sortItemList.add(itemList[22])

        //반지
        sortItemList.add(itemList[0])
        sortItemList.add(itemList[3])
        sortItemList.add(itemList[7])
        sortItemList.add(itemList[12])

        //펜던트 얼장 눈장 귀걸이 벨트
        sortItemList.add(itemList[4])
        sortItemList.add(itemList[8])
        sortItemList.add(itemList[5])
        sortItemList.add(itemList[9])
        sortItemList.add(itemList[10])
        sortItemList.add(itemList[18])

        // 기계 심장, 안드로이드, 포켓아이템, 뱃지, 훈장
        sortItemList.add(itemList[24])
        sortItemList.add(itemList[23])
        sortItemList.add(itemList[17])
        sortItemList.add(itemList[6])
        sortItemList.add(itemList[11])

        //빈 아이템 삭제
        sortItemList.removeIf { it.name == "" }

//        Log.d("TAG", "sortItemList: " + sortItemList)
        return sortItemList
    }


}