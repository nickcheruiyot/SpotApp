package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.Repository.FavoritePlaceRepository
import kotlinx.coroutines.flow.Flow

class GetFavoritePlaceUseCase(
    private val favoritePlaceRepository: FavoritePlaceRepository
) {
    suspend fun execute(): Flow<List<Place>> {
        return favoritePlaceRepository.getFavoritePlaces()
    }
}