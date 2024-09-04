package com.example.findmyip.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findmyip.data.RetrofitInstance
import com.example.findmyip.model.IpInfo
import kotlinx.coroutines.launch

class IpViewModel : ViewModel() {
    private val _ipInfo = mutableStateOf<IpInfo?>(null)
    val ipInfo: State<IpInfo?> = _ipInfo

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    fun fetchInfo() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = RetrofitInstance.api.getIpInfo()
                _ipInfo.value = response
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
            _isLoading.value = false
        }
    }
}