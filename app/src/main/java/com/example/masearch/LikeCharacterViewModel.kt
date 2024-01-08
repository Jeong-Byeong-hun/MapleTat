package com.example.masearch

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.vo.LikeCharacterVo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LikeCharacterViewModel @Inject constructor(private val likeCharacterRepository: LikeCharacterRepository) :
    ViewModel() {
    private val _characterData = MutableLiveData<List<LikeCharacterVo>>()
    val characterData: LiveData<List<LikeCharacterVo>> get() = _characterData

    fun insertLikeCharacter(name: String, imgUrl: String, level : String) {
        viewModelScope.launch {
            try {
                val likeCharacterVo = LikeCharacterVo(nickName = name, imgUrl = imgUrl, level = level)
                likeCharacterRepository.insertCharacter(likeCharacterVo)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteLikeCharacter(name: String) {
        viewModelScope.launch {
            try {
                likeCharacterRepository.deleteUser(name)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllList() {
        likeCharacterRepository.getAllCharacterList().observeForever {
            _characterData.value = it
            Log.d("TAG", "getAllList: " + _characterData.value.toString())
        }
    }

    suspend fun isExistCharacter(name: String): Boolean {
        return withContext(Dispatchers.IO) {
            likeCharacterRepository.isExistCharacter(name)
        }
    }

}