package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class TitleVO(
    @SerializedName("title_name")
    val titleName: String,
    @SerializedName("title_icon")
    val titleIcon: String,
    @SerializedName("title_description")
    val titleDescription: String,
    @SerializedName("date_expire")
    val dateExpire: String?,
    @SerializedName("date_option_expire")
    val dateOptionExpire: String?

)