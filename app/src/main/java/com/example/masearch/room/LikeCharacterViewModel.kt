package com.example.masearch.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.vo.LikeCharacterVo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LikeCharacterViewModel @Inject constructor(private val likeCharacterRepository: LikeCharacterRepository) :
    ViewModel() {
    private val _characterData = MutableStateFlow<List<LikeCharacterVo>>(emptyList())
    val characterData: StateFlow<List<LikeCharacterVo>> get() = _characterData

    fun insertLikeCharacter(name: String, imgUrl: String, level: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val likeCharacterVo =
                        LikeCharacterVo(nickName = name, imgUrl = imgUrl, level = level)
                    likeCharacterRepository.insertCharacter(likeCharacterVo)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun deleteLikeCharacter(name: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    likeCharacterRepository.deleteUser(name)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun getAllList() {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _characterData.emit(likeCharacterRepository.getAllCharacterList())
            }
        }

    }

    suspend fun isExistCharacter(name: String): Boolean {
        return withContext(Dispatchers.IO) {
            likeCharacterRepository.isExistCharacter(name)
        }
    }
}