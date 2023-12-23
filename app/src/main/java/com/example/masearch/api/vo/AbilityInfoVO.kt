package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class AbilityInfoVO(
    @SerializedName("ability_no")
    val abilityNo: String,
    @SerializedName("ability_grade")
    val abilityGrade: String,
    @SerializedName("ability_value")
    val abilityValue: String
)
