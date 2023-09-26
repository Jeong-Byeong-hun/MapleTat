package com.example.masearch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.CharacterSearch
import com.example.masearch.api.vo.BaseVo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val characterSearch: CharacterSearch) :
    ViewModel() {
    private var baseInfo: MutableLiveData<BaseVo> = MutableLiveData()
    private var errorLiveData: MutableLiveData<String> = MutableLiveData()
    fun getData() = baseInfo

    fun getErrorLiveData() = errorLiveData

    fun clearErrorData() {
        errorLiveData.value = null
    }


    fun getUserData(id: String) {
        val userId = mutableMapOf<String, String>()
        userId["ID"] = id

        Log.d("MainViewModel", "getUserData: $userId")

        viewModelScope.launch {
            try {
                val data = characterSearch.getCharacterInfo(userId)
                Log.d("MainViewModel", "getUserData: " + data.body().toString())
                Log.d("MainViewModel", "getUserData: " + data.body()?.data!!.characterVo)
                if (data.body()?.data!!.items.isNotEmpty()) {
                    baseInfo.postValue(data.body()!!.data)
                    errorLiveData.postValue("")
                } else {
                    throw Exception()
                }
            } catch (e: Exception) {
                errorLiveData.postValue("아이디를 다시 한 번 확인해주시거나 핸즈가 열려있는지 확인해주세요.")
                Log.d("MainViewModel", "getUserData: 검색결과가 없습니다..")
            }

        }

    }
}