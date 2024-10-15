package com.example.spotapp.Presentation.Places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Model.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceDetailsViewModel @Inject constructor(
    private val addPlaceToListUseCase: AddPlaceToListUseCase
) : ViewModel() {

    // Function to add a place to a list
    fun addPlaceToList(place: Place) {
        viewModelScope.launch {
            addPlaceToListUseCase.addPlace(place)
        }
    }
}
