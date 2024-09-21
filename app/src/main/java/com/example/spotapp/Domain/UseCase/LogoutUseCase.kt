package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.AuthRepository

class LogoutUseCase(
    private val authRepository: AuthRepository
) {
    fun execute() {
        authRepository.logout()
    }
}