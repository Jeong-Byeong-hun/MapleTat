package com.example.masearch

import com.example.masearch.api.CharacterSearch
import com.example.masearch.api.vo.ResultVO
import javax.inject.Inject

class UserRepository @Inject constructor(private val characterSearch: CharacterSearch) {

    suspend fun getUserData(id: String): ResultVO {
        val userId = mutableMapOf<String, String>()
        userId["ID"] = id.trim()

        try {
            val data = characterSearch.getCharacterInfo(userId)
            if (data.body() != null) {
                return data.body()!!
            } else {
                throw Exception("No data found.")
            }
        } catch (e: Exception) {
            throw Exception("Error fetching user data: ${e.message}")
        }
    }
}