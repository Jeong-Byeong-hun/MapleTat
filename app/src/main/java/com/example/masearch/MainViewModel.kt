package com.example.masearch

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.CharacterSearch
import com.example.masearch.api.vo.ResultVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRepository @Inject constructor(private val characterSearch: CharacterSearch) {

    suspend fun getUserData(id: String): ResultVO {
        val userId = mutableMapOf<String, String>()
        userId["ID"] = id

        try {
            val data = characterSearch.getCharacterInfo(userId)
            if (data.body()?.data!!.items.isNotEmpty()) {
                return data.body()!!.data
            } else {
                throw Exception("No data found.")
            }
        } catch (e: Exception) {
            throw Exception("Error fetching user data: ${e.message}")
        }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
//    private var baseInfo: MutableLiveData<BaseVo> = MutableLiveData()
//    private var errorLiveData: MutableLiveData<String> = MutableLiveData()

    private val _userData = MutableLiveData<ResultVO>()
    val userData: LiveData<ResultVO> get() = _userData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData
//    fun getData() = baseInfo

//    fun getErrorLiveData() = errorLiveData

    fun clearErrorData() {
        _errorLiveData.value = null
    }


    fun getUserData(id: String) {
        viewModelScope.launch {
            try {
                val result = userRepository.getUserData(id)
                _userData.value = result
                _errorLiveData.value = ""
            } catch (e: Exception) {
                _errorLiveData.value = "아이디를 다시 한 번 확인해주시거나 핸즈가 열려있는지 확인해주세요."
                Log.d("MainViewModel", "getUserData: 검색결과가 없습니다..")
            }

        }

    }
}