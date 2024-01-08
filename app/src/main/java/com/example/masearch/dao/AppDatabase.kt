package com.example.masearch.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.masearch.api.vo.LikeCharacterVo
import com.example.masearch.api.vo.RecentSearchVO

@Database(
    entities = [LikeCharacterVo::class, RecentSearchVO::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun likeCharacterDao(): LikeCharacterDao

    abstract fun recentSearchDao(): RecentSearchDao
}