package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class AbilityVO(
    @SerializedName("ability_grade")
    val grade: String,

    @SerializedName("ability_info")
    val info: List<List<String>>
)