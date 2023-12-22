package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class AdditionalPotentialOption(
    @SerializedName("additional_potential_option_grade")
    val additionalPotentialOptionGrade: String,

    @SerializedName("additional_potential_option_1")
    val additionalPotentialOption1: String,

    @SerializedName("additional_potential_option_2")
    val additionalPotentialOption2: String,

    @SerializedName("additional_potential_option_3")
    val additionalPotentialOption3: String
)
