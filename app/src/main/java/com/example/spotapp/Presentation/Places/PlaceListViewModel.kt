package com.example.spotapp.Presentation.Places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.Repository.PlaceRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceListViewModel @Inject constructor(
    private val placeRepository: PlaceRepositoryInterface
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places

    init {
        loadPlaces()
    }

    private fun loadPlaces() {
        viewModelScope.launch {
            _places.value = placeRepository.getPlaces()
        }
    }
}
