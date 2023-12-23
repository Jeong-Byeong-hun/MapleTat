package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class HyperStatDetailVO(
    @SerializedName("stat_type")
    val statType: String,
    @SerializedName("stat_point")
    val statPoint: Int?,
    @SerializedName("stat_level")
    val statLevel: Int,
    @SerializedName("stat_increase")
    val statIncrease: String?
)
