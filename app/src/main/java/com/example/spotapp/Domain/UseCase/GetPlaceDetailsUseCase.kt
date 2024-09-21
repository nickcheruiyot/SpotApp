package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow

class GetPlaceDetailsUseCase(
    private val placeRepository: PlaceRepository
) {
    suspend fun execute(placeId: String): Flow<Place> {
        return placeRepository.getPlaceDetails(placeId)
    }
}