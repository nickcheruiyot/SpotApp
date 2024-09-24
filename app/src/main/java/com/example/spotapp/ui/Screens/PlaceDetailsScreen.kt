package com.example.spotapp.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.spotapp.Presentation.Places.PlaceListViewModel

@Composable

fun PlaceDetailsScreen(backStackEntry: NavBackStackEntry, viewModel: PlaceListViewModel = hiltViewModel()) {
    val placeId = backStackEntry.arguments?.getString("placeId") ?: return
    val place = viewModel.getPlaceById(placeId)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        place?.let {
            Text(text = "Place Name: ${it.name}")
            Text(text = "Description: ${it.description}")
        }
    }
}
