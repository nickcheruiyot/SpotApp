package com.example.spotapp.Presentation.Places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.UseCase.GetNearbyPlacesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlaceViewModel @Inject constructor(
    private val getNearbyPlacesUseCase: GetNearbyPlacesUseCase
) : ViewModel()  {

    fun getPlaceById(placeId: String): Place? {
        // Logic to fetch the place by ID from the repository
        return repository.getPlaceById(placeId)
    }

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> get() = _places

    fun fetchNearbyPlaces(location: String, radius: Int, type: String) {
        viewModelScope.launch {
            getNearbyPlacesUseCase.execute(location, radius, type).collect { result ->
                _places.value = result
            }
        }
    }

}