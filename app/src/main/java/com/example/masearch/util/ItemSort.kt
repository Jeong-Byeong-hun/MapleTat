package com.example.masearch.util

import android.util.Log
import com.example.masearch.api.vo.Items

class ItemSort {

    val itemNameList = mutableListOf<String>("무기", "보조", "엠블렘")
    fun sortItemList(itemList: MutableList<Items>): MutableList<Items> {
        var sortItemList = mutableListOf<Items>()
        for (type in itemNameList) {
            for (item in itemList) {
                if (item.itemType.contains(type)){
                    sortItemList.add(item)
                }
            }
        }

        Log.d("TAG", "sortItemList: " + sortItemList)
        return sortItemList
    }
}