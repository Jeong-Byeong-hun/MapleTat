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
class MainViewModel @Inject constructor(private val characterSearch: CharacterSearch) : ViewModel() {
    var baseInfo : MutableLiveData<BaseVo> = MutableLiveData()

    fun getData() = baseInfo


    fun getUserData(id: String) {
        val userId = mutableMapOf<String, String>()
        userId["ID"] = id

        Log.d("MainViewModel", "getUserData: $userId")

        viewModelScope.launch {
            val data = characterSearch.getCharacterInfo(userId)

            when (data.isSuccessful) {
                true -> {
                    Log.d("MainViewModel", "getUserData: " + data.body().toString())
                    Log.d("MainViewModel", "getUserData: " + data.body()?.data!!.characterVo)
//                    characterInfo = data.body()!!.data.character
                    baseInfo.postValue(data.body()!!.data)
                }

                else -> {

                }
            }

        }

    }
}