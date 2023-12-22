package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class ResultVO(
    @SerializedName("basic")
    val basic: BasicVO,

    @SerializedName("stat")
    val stat: StatVO,

    @SerializedName("hyper-stat")
    val hyperStat: HyperStatVO,

    @SerializedName("ability")
    val ability: AbilityVO,

    @SerializedName("item-equipment")
    val itemEquipment : ItemEquipmentVO


)