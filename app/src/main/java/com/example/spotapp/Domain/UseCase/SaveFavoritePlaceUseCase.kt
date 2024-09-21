package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Domain.Model.Place

class SaveFavoritePlaceUseCase(
    private val favoritePlaceRepository: FavoritePlaceRepository
) {
    suspend fun execute(place: Place) {
        favoritePlaceRepository.saveFavoritePlace(place)
    }
}