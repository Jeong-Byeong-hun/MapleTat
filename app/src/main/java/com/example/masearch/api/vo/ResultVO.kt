package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class ResultVO(
    @SerializedName("basic")
    val basic: BasicVO = BasicVO(),

    @SerializedName("stat")
    val stat: StatVO = StatVO(),

    @SerializedName("hyper-stat")
    val hyperStat: HyperStatVO = HyperStatVO(),

    @SerializedName("ability")
    val ability: AbilityVO = AbilityVO(),

    @SerializedName("item-equipment")
    val itemEquipment: ItemEquipmentVO = ItemEquipmentVO(),

    @SerializedName("dojang")
    val dojang: DojangVO = DojangVO()
)