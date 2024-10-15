package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlacesByCategoryUseCase @Inject constructor(
    private val repository: PlaceRepository
) {
    suspend fun execute(category: String, location: String, radius: Int): Flow<List<Place>> {
        return repository.getPlacesByCategory(category, location, radius)
    }
}