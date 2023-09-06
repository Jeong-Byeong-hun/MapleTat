package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class BaseVo(
    @SerializedName("character")
    val characterVo: CharacterVo,

    @SerializedName("items")
    val items: MutableList<Items>
)