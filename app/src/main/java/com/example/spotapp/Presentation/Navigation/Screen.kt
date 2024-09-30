package com.example.spotapp.Presentation.Navigation

sealed interface Screen(val route: String) {
    object Login : Screen("login")
    object Map : Screen("map") // Make sure this is correctly referenced
}