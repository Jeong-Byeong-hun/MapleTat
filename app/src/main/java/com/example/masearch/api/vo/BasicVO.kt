package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class BasicVO(
    @SerializedName("character_name")
    val charName : String = "",
    @SerializedName("world_name")
    val worldName : String = "",
    @SerializedName("character_class")
    val charClass : String = "",
    @SerializedName("character_level")
    val level : Int = 0,
    @SerializedName("character_image")
    val charImage : String = "",
)
