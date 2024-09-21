package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.AuthRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val authRepository: AuthRepository
)  {
    suspend fun execute(email: String, password: String): Flow<Result<AuthResult>> {
        return authRepository.login(email, password)
    }
}