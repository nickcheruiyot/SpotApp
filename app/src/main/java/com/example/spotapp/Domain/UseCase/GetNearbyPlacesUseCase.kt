package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyPlacesUseCase @Inject constructor(
    private val placeRepository: PlaceRepository
) {
    suspend fun execute(location: String, radius: Int, type: String): Flow<List<Place>> {
        return placeRepository.getNearbyPlaces(location, radius, type)
    }
}