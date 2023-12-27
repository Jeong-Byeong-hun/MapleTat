package com.example.masearch.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.masearch.api.vo.LikeCharacterVo

@Dao
interface LikeCharacterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLickCharacter(likeCharacterVo: LikeCharacterVo)

    @Query("SELECT * FROM like_table")
    suspend fun getAllLickCharacter(): List<LikeCharacterVo>

    @Query("DELETE FROM like_table WHERE nickName = :nickName")
    suspend fun deleteData(nickName: String)
}