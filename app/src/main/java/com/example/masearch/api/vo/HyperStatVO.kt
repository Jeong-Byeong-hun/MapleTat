package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class HyperStatVO(
    @SerializedName("use_preset_no")
    val usePresetNum : String,

    @SerializedName("hyper_stat_preset_1")
    val hyperStatFirst: List<HyperStatDetailVO>,

    @SerializedName("hyper_stat_preset_2")
    val hyperStatSecond: List<HyperStatDetailVO>,

    @SerializedName("hyper_stat_preset_3")
    val hyperStatThird: List<HyperStatDetailVO>,
)