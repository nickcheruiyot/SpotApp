package com.example.spotapp.Presentation.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Repository.AuthRepositoryInterface
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel@Inject constructor(
    private val authRepository: AuthRepositoryInterface
) : ViewModel() {

    private val _uiState = MutableLiveData(LoginUiState())
    val uiState: LiveData<LoginUiState> = _uiState

    fun login() {
        _uiState.value = _uiState.value?.copy(isLoading = true)
        viewModelScope.launch {
            authRepository.login()
            _uiState.value = _uiState.value?.copy(isLoading = false)
        }
    }
}
data class LoginUiState(val isLoading: Boolean = false)