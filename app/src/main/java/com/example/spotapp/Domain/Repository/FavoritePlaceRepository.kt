package com.example.spotapp.Domain.Repository

import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow

interface FavoritePlaceRepository {
    suspend fun saveFavoritePlace(place: Place)
    suspend fun getFavoritePlaces(): Flow<List<Place>>
    suspend fun deleteFavoritePlace(place: Place)
}