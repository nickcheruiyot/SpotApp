package com.example.spotapp.Presentation.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Repository.AuthRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepositoryInterface
) : ViewModel() {

    // Using StateFlow instead of LiveData for better integration with Compose
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun login() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            authRepository.login()
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }
}

data class LoginUiState(val isLoading: Boolean = false)