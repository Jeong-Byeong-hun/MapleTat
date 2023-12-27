package com.example.masearch.room

import android.content.Context
import androidx.room.Room
import com.example.masearch.dao.AppDatabase
import com.example.masearch.dao.LikeCharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "LikeCharacterDatabase"
        ).build()
    }

    @Provides
    fun provideLikeCharacterDao(database: AppDatabase): LikeCharacterDao {
        return database.likeCharacterDao()
    }

}