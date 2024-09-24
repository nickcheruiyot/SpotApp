package com.example.spotapp.Presentation.Map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Domain.Model.Place
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places

    // Correct way to call the suspend function
    fun getNearbyPlaces(location: String, radius: Int, type: String) {
        viewModelScope.launch {
            placeRepository.getNearbyPlaces(location, radius, type).collect { places ->
                _places.value = places  // Collect the flow
            }
        }
    }
}