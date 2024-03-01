package com.example.masearch.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.vo.RecentSearchVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecentSearchViewModel @Inject constructor(private val recentSearchRepository: RecentSearchRepository) :
    ViewModel() {
    private val _recentSearchData = MutableStateFlow<List<RecentSearchVO>>(emptyList())
    val recentSearchData: StateFlow<List<RecentSearchVO>> get() = _recentSearchData

    init {
        getAllNameList()
    }

    fun insertRecentName(name: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val recentSearchVO = RecentSearchVO(nickName = name)
                    recentSearchRepository.insertCharacter(recentSearchVO)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun deleteRecentName(name: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    recentSearchRepository.deleteName(name)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getAllNameList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _recentSearchData.emit(recentSearchRepository.getAllNameList())
            }
        }
    }

}