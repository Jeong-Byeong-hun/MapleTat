package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class AbilityVo(
    @SerializedName("grade")
    val grade: String,
    @SerializedName("value")
    val value: MutableList<String>
)
