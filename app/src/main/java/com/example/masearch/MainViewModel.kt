package com.example.masearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.vo.ResultVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _userData = MutableLiveData<ResultVO>()
    val userData: LiveData<ResultVO> get() = _userData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData
    fun clearErrorData() {
        _errorLiveData.value = null
    }


    fun getUserData(id: String) {
        viewModelScope.launch {
            try {
                val result = userRepository.getUserData(id)
                _userData.value = result
                clearErrorData()
            } catch (e: Exception) {
                _errorLiveData.value = e.message.toString()
            }
        }
    }
}