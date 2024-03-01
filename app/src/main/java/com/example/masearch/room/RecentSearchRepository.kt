package com.example.masearch.room

import androidx.lifecycle.LiveData
import com.example.masearch.api.vo.RecentSearchVO
import com.example.masearch.dao.RecentSearchDao
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RecentSearchRepository @Inject constructor(private val recentSearchDao: RecentSearchDao) {
    suspend fun insertCharacter(recentSearchVO: RecentSearchVO) {
        recentSearchDao.insertRecentName(recentSearchVO)
    }

    suspend fun deleteName(nickname: String) {
        recentSearchDao.deleteRecentNameData(nickname)
    }

    fun getAllNameList(): List<RecentSearchVO> {
        return recentSearchDao.getAllListName()
    }

}