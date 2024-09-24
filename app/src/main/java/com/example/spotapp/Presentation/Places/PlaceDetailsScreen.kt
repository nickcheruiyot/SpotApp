package com.example.spotapp.Presentation.Places

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry

@Composable
fun PlaceDetailsScreen(backStackEntry: NavBackStackEntry) {
    val placeId = backStackEntry.arguments?.getString("placeId") // Get place ID from nav args
    val viewModel: PlaceViewModel  = viewModel() // Get your ViewModel instance

    // Call the getPlaceById function
    val place = viewModel.getPlaceById(placeId ?: "")

    // Display your place details here
    place?.let {
        // Your UI logic to display place details
    } ?: run {
        // Handle the case where the place is not found
        Text("Place not found")
    }
}
