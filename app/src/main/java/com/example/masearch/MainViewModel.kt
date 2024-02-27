package com.example.masearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masearch.api.vo.ResultVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _userData = MutableStateFlow(ResultVO())
    val userData: StateFlow<ResultVO> get() = _userData

    private val _errorLiveData = MutableStateFlow("")
    val errorLiveData: StateFlow<String> get() = _errorLiveData
    fun clearErrorData() {
        _errorLiveData.value = ""
    }


    fun getUserData(id: String) {
        viewModelScope.launch {
            try {
                _userData.emit(userRepository.getUserData(id))
                clearErrorData()
            } catch (e: Exception) {
                _errorLiveData.emit(e.message.toString())
            }
        }
    }
}