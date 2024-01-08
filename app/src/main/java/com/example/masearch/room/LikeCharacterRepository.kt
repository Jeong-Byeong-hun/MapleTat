package com.example.masearch.room

import androidx.lifecycle.LiveData
import com.example.masearch.api.vo.LikeCharacterVo
import com.example.masearch.dao.LikeCharacterDao
import javax.inject.Inject

class LikeCharacterRepository @Inject constructor(private val likeCharacterDao: LikeCharacterDao) {
    suspend fun insertCharacter(likeCharacterVo: LikeCharacterVo) {
        likeCharacterDao.insertLickCharacter(likeCharacterVo)
    }

    suspend fun deleteUser(nickname: String) {
        likeCharacterDao.deleteData(nickname)
    }

    fun getAllCharacterList(): LiveData<List<LikeCharacterVo>> {
        return likeCharacterDao.getAllLikeCharacter()
    }

     fun isExistCharacter(nickname: String): Boolean {
        val existCharacter = likeCharacterDao.getCharacterByName(nickname)
        return existCharacter != null
    }


}