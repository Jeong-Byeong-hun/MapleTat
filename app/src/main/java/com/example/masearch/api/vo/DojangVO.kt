package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class DojangVO(
    @SerializedName("dojang_best_floor")
    val bestFloor: Int = 0
)
