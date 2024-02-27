package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class ItemEquipmentVO(
    @SerializedName("item_equipment")
    val itemEquipmentList : List<ItemEquipmentDetailVO> = emptyList(),
    @SerializedName("title")
    val title : TitleVO? = TitleVO()
)
