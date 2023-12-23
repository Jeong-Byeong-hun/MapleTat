package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class StatVO(
    @SerializedName("final_stat")
    val finalStatList: List<FinalStat>
)

data class FinalStat(
    @SerializedName("stat_name")
    val statName: String,
    @SerializedName("stat_value")
    val statValue: String?
)