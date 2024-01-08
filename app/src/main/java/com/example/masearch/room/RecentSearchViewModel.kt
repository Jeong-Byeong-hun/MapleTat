package com.example.masearch.room

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.vo.RecentSearchVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentSearchViewModel @Inject constructor(private val recentSearchRepository: RecentSearchRepository) :
    ViewModel() {
    private val _recentSearchData = MutableLiveData<List<RecentSearchVO>>()
    val recentSearchData: LiveData<List<RecentSearchVO>> get() = _recentSearchData

    init {
        getAllNameList()
    }
    fun insertRecentName(name: String) {
        viewModelScope.launch {
            try {
                val recentSearchVO = RecentSearchVO(nickName = name)
                recentSearchRepository.insertCharacter(recentSearchVO)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteRecentName(name: String) {
        viewModelScope.launch {
            try {
                recentSearchRepository.deleteName(name)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getAllNameList() {
        recentSearchRepository.getAllNameList().observeForever {
            _recentSearchData.value = it
            Log.d("TAG", "getAllList: " + _recentSearchData.value.toString())
        }
    }

}