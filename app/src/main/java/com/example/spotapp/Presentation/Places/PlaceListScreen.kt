package com.example.spotapp.Presentation.Places

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PlaceListScreen(navController: NavController, viewModel: PlaceListViewModel = hiltViewModel()) {
    val places = viewModel.places.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        places.value.forEach { place ->
            Text(
                text = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(Screen.PlaceDetails.route + "/${place.id}")
                    }
            )
        }
    }
}

