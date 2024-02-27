package com.example.masearch

import android.util.Log
import com.example.masearch.api.CharacterSearch
import com.example.masearch.api.vo.ResultVO
import timber.log.Timber
import javax.inject.Inject

class UserRepository @Inject constructor(private val characterSearch: CharacterSearch) {

    suspend fun getUserData(id: String): ResultVO {
        val userId = mutableMapOf<String, String>()
        userId["ID"] = id.trim()

        try {
            val data = characterSearch.getCharacterInfo(userId)
            if (data.body() != null) {
                if (data.body()!!.basic.charName.isEmpty()){
                    throw Exception("23.12.21 이후 접속한 캐릭터만 검색 가능합니다.")
                }
                Log.d("TAG", "getUserData: " + data.body()!!.basic)
                return data.body()!!
            } else {
                throw Exception("23.12.21 이후 접속한 캐릭터만 검색 가능합니다.")
            }
        } catch (e: Exception) {
            throw Exception("해당 캐릭터를 찾을 수 없습니다. 아이디를 확인 해 주세요.\n영어 대소문자를 구분해주세요.\n23.12.21 이후 접속한 캐릭터만 검색 가능합니다. ")
        }
    }
}