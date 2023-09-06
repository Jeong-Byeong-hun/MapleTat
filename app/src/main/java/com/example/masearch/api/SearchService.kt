package com.example.masearch.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SearchService {
    @POST("/maple/getCharacter")
    suspend fun getCharacter(@Body id:Map<String,String>) : Response<BaseResult>
}