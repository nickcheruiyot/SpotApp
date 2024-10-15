package com.example.spotapp.Presentation.Places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Data.Model.TipEntity
import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.UseCase.AddTipUseCase
import com.example.spotapp.Domain.UseCase.GetNearbyPlacesUseCase
import com.example.spotapp.Domain.UseCase.GetPlaceByIdUseCase
import com.example.spotapp.Domain.UseCase.GetTipsForPlaceUseCase
import com.example.spotapp.Domain.UseCase.RatePlaceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PlaceViewModel @Inject constructor(
    private val getNearbyPlacesUseCase: GetNearbyPlacesUseCase,
    private val getPlaceByIdUseCase: GetPlaceByIdUseCase,
    private val ratePlaceUseCase: RatePlaceUseCase,
    private val getTipsForPlaceUseCase: GetTipsForPlaceUseCase,  // Inject GetTipsForPlaceUseCase
    private val addTipUseCase: AddTipUseCase  // Inject AddTipUseCase
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> get() = _places

    private val _selectedPlace = MutableStateFlow<Place?>(null)
    val selectedPlace: StateFlow<Place?> get() = _selectedPlace

    private val _ratingSuccess = MutableStateFlow<Boolean?>(null)
    val ratingSuccess: StateFlow<Boolean?> get() = _ratingSuccess

    // State to hold tips for the current place
    private val _tips = MutableStateFlow<List<TipEntity>>(emptyList())
    val tips: StateFlow<List<TipEntity>> get() = _tips

    // Function to get place details by ID
    fun getPlaceById(placeId: String) {
        viewModelScope.launch {
            getPlaceByIdUseCase.execute(placeId).collect { place ->
                _selectedPlace.value = place
            }
        }
    }

    // Function to fetch nearby places
    fun fetchNearbyPlaces(location: String, radius: Int, type: String) {
        viewModelScope.launch {
            getNearbyPlacesUseCase.execute(location, radius, type).collect { result ->
                _places.value = result
            }
        }
    }

    // Function to rate a place
    fun ratePlace(placeId: String, rating: String) {
        viewModelScope.launch {
            val result = ratePlaceUseCase.execute(placeId, rating)
            _ratingSuccess.value = result // Set success/failure state based on the use case result
        }
    }

    // Function to fetch tips for a specific place
    fun fetchTipsForPlace(placeId: String) {
        viewModelScope.launch {
            getTipsForPlaceUseCase.execute(placeId).collect { tipList ->
                _tips.value = tipList
            }
        }
    }

    // Function to add a new tip with username
    fun addTipForPlace(tip: TipEntity) {
        viewModelScope.launch {
            try {
                addTipUseCase.execute(tip) // Execute the use case to add the new tip
                fetchTipsForPlace(tip.placeId) // Refresh the tips list after adding
            } catch (e: Exception) {
                // Handle the error if the tip couldn't be added
                e.printStackTrace()

                // Add this function to PlaceViewModel
                fun addPlaceToList(place: Place) {
                    viewModelScope.launch {
                        // Call a use case or repository function to add this place to the list.
                        // Assuming there is an AddPlaceToListUseCase that takes a Place and adds it to a list.
                        try {
                            addPlaceToListUseCase.execute(place) // Adjust with your use case or repository function.
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }



            }
        }
    }
}

