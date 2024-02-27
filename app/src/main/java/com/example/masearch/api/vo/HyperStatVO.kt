package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class HyperStatVO(
    @SerializedName("use_preset_no")
    val usePresetNum : String = "0",

    @SerializedName("hyper_stat_preset_1")
    val hyperStatFirst: List<HyperStatDetailVO> = emptyList(),

    @SerializedName("hyper_stat_preset_2")
    val hyperStatSecond: List<HyperStatDetailVO> = emptyList(),

    @SerializedName("hyper_stat_preset_3")
    val hyperStatThird: List<HyperStatDetailVO> = emptyList(),
)