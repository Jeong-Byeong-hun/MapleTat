package com.example.masearch.api

import com.example.masearch.api.vo.BaseVo
import com.google.gson.annotations.SerializedName
import java.util.Objects

data class BaseResult(
    @SerializedName("data")
    var data : BaseVo,
)