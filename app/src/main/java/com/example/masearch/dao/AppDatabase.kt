package com.example.masearch.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.masearch.api.vo.LikeCharacterVo

@Database(entities = [LikeCharacterVo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun likeCharacterDao(): LikeCharacterDao
}