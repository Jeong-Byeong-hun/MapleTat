package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class HyperStatVO(
    @SerializedName("use_preset_no")
    val usePresetNum : String,

    @SerializedName("hyper_stat_preset_1")
    val hyperStatFirst: List<HyperStatDetail>,

    @SerializedName("hyper_stat_preset_2")
    val hyperStatSecond: List<HyperStatDetail>,

    @SerializedName("hyper_stat_preset_3")
    val hyperStatThird: List<HyperStatDetail>,
)


data class HyperStatDetail(
    @SerializedName("stat_type")
    val statType: String,
    @SerializedName("stat_point")
    val statPoint: Int?,
    @SerializedName("stat_level")
    val statLevel: Int,
    @SerializedName("stat_increase")
    val statIncrease: String?
)