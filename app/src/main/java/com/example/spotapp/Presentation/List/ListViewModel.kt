package com.example.spotapp.Presentation.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.UseCase.GetListItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(
    private val getListItemsUseCase: GetListItemsUseCase
) : ViewModel() {

    private val _savedPlaces = MutableStateFlow<List<Place>>(emptyList())
    val savedPlaces: StateFlow<List<Place>> = _savedPlaces

    private val _likedPlaces = MutableStateFlow<List<Place>>(emptyList())
    val likedPlaces: StateFlow<List<Place>> = _likedPlaces

    fun fetchSavedPlaces() {
        viewModelScope.launch {
            getListItemsUseCase.getSavedPlaces().collect { places ->
                _savedPlaces.value = places
            }
        }
    }

    fun fetchLikedPlaces() {
        viewModelScope.launch {
            getListItemsUseCase.getLikedPlaces().collect { places ->
                _likedPlaces.value = places
            }
        }
    }

    fun createNewList(name: String, places: List<Place>) {
        viewModelScope.launch {
            getListItemsUseCase.createNewList(name, places)
        }
    }
}