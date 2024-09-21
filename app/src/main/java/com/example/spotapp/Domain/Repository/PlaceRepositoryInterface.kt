package com.example.spotapp.Domain.Repository

import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow

interface PlaceRepositoryInterface {
    suspend fun getNearbyPlaces(location: String, radius: Int, type: String): Flow<List<Place>>
    suspend fun getPlaceDetails(placeId: String): Flow<Place>
    suspend fun savePlace(place: Place): Flow<Unit>
    suspend fun deletePlace(placeId: String): Flow<Unit>

}