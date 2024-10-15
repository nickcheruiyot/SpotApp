package com.example.spotapp.Presentation.Search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.UseCase.GetPlacesByCategoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getPlacesByCategoryUseCase: GetPlacesByCategoryUseCase
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> get() = _places

    fun fetchPlacesByCategory(category: String, location: String, radius: Int) {
        viewModelScope.launch {
            getPlacesByCategoryUseCase.execute(category, location, radius).collect { result ->
                _places.value = result
            }
        }
    }
}
