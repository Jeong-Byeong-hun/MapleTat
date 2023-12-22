package com.example.masearch.api

import com.example.masearch.api.vo.ResultVO
import com.google.gson.annotations.SerializedName

data class BaseResult(
    @SerializedName("data")
    var data : ResultVO,
)