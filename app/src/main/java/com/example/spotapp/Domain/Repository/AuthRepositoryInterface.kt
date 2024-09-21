package com.example.spotapp.Domain.Repository

interface AuthRepositoryInterface {
    fun login(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit)
    fun register(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit)
    fun logout()
    fun isLoggedIn(): Boolean
}