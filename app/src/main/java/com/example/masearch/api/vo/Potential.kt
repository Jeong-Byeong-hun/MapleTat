package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class Potential(
    @SerializedName("grade")
    val grade: String,

    @SerializedName("option")
    val option: MutableList<Any>
)
