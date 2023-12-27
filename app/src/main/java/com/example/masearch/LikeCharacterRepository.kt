package com.example.masearch

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

    suspend fun getAllCharacterList(): List<LikeCharacterVo> {
        return likeCharacterDao.getAllLickCharacter()
    }
}