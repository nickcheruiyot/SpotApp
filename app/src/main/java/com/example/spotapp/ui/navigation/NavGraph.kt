package com.example.spotapp.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spotapp.Presentation.List.ListScreen
import com.example.spotapp.Presentation.Login.LoginScreen
import com.example.spotapp.Presentation.Map.MapScreen
import com.example.spotapp.Presentation.Places.PlaceListScreen
import com.example.spotapp.Presentation.Search.SearchScreen
import com.example.spotapp.Presentation.Signup.SignUpScreen
import com.example.spotapp.ui.Screens.DetailsScreen
import com.example.spotapp.ui.Screens.FavoritesScreen
import com.example.spotapp.ui.Screens.HomeScreen
import com.example.spotapp.ui.Screens.PlaceDetailsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.SignUp.route) {  // Add this composable for the SignUpScreen
            SignUpScreen(navController)
        }
        composable(route = Screen.Map.route) {
            MapScreen()
        }
        composable(route = Screen.PlaceList.route) {
            PlaceListScreen(navController)
        }
        composable(route = Screen.PlaceDetails.route) { backStackEntry ->
            PlaceDetailsScreen(backStackEntry)
        }
        composable(route = Screen.Favorites.route) {
            FavoritesScreen(navController)
        }
        // Add the Search screen navigation
        composable(route = Screen.Search.route) {
            SearchScreen(navController) { category ->
                // Implement logic to fetch places by the selected category
            }
        }
        // Add ListScreen to NavGraph
        composable(route = Screen.List.route) {
            ListScreen(navController)
        }
    }
}


