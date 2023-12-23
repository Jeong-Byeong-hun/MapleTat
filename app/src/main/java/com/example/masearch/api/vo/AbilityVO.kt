package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class AbilityVO(
    @SerializedName("ability_grade")
    val grade: String,

    @SerializedName("ability_info")
    val info: List<AbilityInfo>
)

data class AbilityInfo(
    @SerializedName("ability_no")
    val abilityNo: String,
    @SerializedName("ability_grade")
    val abilityGrade: String,
    @SerializedName("ability_value")
    val abilityValue: String
)