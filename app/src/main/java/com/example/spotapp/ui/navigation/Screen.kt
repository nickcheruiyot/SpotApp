package com.example.spotapp.ui.navigation

sealed class Screen
    (val route: String) {
    object Login : Screen("login")
    object Map : Screen("map")
    object PlaceList : Screen("place_list")
    object PlaceDetails : Screen("place_details")
    object Favorites : Screen("favorites") // Add this line for the Favorites screen
}


