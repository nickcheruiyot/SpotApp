package com.example.spotapp.Presentation.Map

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.spotapp.Domain.Model.Location
import com.example.spotapp.Presentation.Places.PlaceViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.rememberCameraPositionState

class MapScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapScreenContent()
        }
    }

    @Composable
    fun MapScreenContent(placeViewModel: PlaceViewModel = hiltViewModel()) {
        val places = placeViewModel.places.collectAsState()
        val userLocation = remember { Location(0.0, 0.0) } // Replace with actual user location

        val cameraPositionState = rememberCameraPositionState {
            position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(
                com.google.android.gms.maps.model.LatLng(userLocation.lat, userLocation.lng), 12f
            )
        }

        GoogleMap(
            cameraPositionState = cameraPositionState
        ) {
            places.forEach { place ->
                Marker(
                    position = LatLng(place.lat, place.lng),
                    title = place.name
                )
            }
        }
    }

    @Preview
    @Composable
    fun PreviewMapScreen() {
        MapScreenContent()
    }

}