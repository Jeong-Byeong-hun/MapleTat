package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class ItemEquipmentDetailVO(
    @SerializedName("item_equipment_part")
    val itemPart: String,

    @SerializedName("item_equipment_slot")
    val itemSlot: String,

    @SerializedName("item_name")
    val itemName : String,

    )
