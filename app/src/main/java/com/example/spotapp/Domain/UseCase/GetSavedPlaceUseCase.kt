package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedPlacesUseCase @Inject constructor(
    private val repository: PlaceRepository
) {
    fun execute(): Flow<List<Place>> {
        return repository.getSavedPlaces()
    }
}
