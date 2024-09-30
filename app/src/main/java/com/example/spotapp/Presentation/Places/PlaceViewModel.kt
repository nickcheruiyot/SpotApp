package com.example.spotapp.Presentation.Places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.UseCase.GetNearbyPlacesUseCase
import com.example.spotapp.Domain.UseCase.GetPlaceByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PlaceViewModel @Inject constructor(
    private val getNearbyPlacesUseCase: GetNearbyPlacesUseCase,
    private val getPlaceByIdUseCase: GetPlaceByIdUseCase // Add a comma here
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> get() = _places

    private val _selectedPlace = MutableStateFlow<Place?>(null)
    val selectedPlace: StateFlow<Place?> get() = _selectedPlace

    fun getPlaceById(placeId: String) {
        viewModelScope.launch {
            getPlaceByIdUseCase.execute(placeId).collect { place ->
                _selectedPlace.value = place
            }
        }
    }

    fun fetchNearbyPlaces(location: String, radius: Int, type: String) {
        viewModelScope.launch {
            getNearbyPlacesUseCase.execute(location, radius, type).collect { result ->
                _places.value = result
            }
        }
    }
}
