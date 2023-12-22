package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class StatVO(
    @SerializedName("final_stat")
    val finalStatList: List<List<String>>
)
