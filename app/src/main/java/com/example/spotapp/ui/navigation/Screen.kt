package com.example.spotapp.ui.navigation
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object SignUp : Screen("sign_up")  // Added this line for the SignUp screen
    object Map : Screen("map")
    object PlaceList : Screen("place_list")
    object PlaceDetails : Screen("place_details")
    object Favorites : Screen("favorites")
    object Search : Screen("search")
    object List : Screen("list")
}


