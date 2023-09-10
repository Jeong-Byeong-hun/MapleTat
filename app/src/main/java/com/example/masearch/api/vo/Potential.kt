package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class Potential(
    @SerializedName("grade")
    val grade: String,

    //잠재 옵션이 없는 경우는 리스트 형태가 이차원 배열형태로 오지 않는다..
    @SerializedName("option")
    val option: MutableList<Any>
)
