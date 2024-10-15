package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.PlaceRepository
import javax.inject.Inject

class RatePlaceUseCase @Inject constructor(
    private val placeRepository: PlaceRepository
) {
    suspend fun execute(placeId: String, rating: String): Boolean {
        return try {
            placeRepository.ratePlace(placeId, rating)  // Call repository function to rate place
            true // Return true if successful
        } catch (e: Exception) {
            false // Return false if there was an error
        }
    }
}