package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.PlaceRepository
import javax.inject.Inject


class UpdatePlaceRatingUseCase @Inject constructor(
    private val repository: PlaceRepository
) {
    suspend fun execute(placeId: String, rating: String) {
        repository.updatePlaceRating(placeId, rating)
    }
}
