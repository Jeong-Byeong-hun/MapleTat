package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class FinalStatVO(
    @SerializedName("stat_name")
    val statName: String,
    @SerializedName("stat_value")
    val statValue: String?
)
