package com.example.masearch.api

import com.example.masearch.api.vo.ResultVO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SearchService {
    @POST("/maple/getInfo")
    suspend fun getCharacter(@Body id:Map<String,String>) : Response<ResultVO>
}