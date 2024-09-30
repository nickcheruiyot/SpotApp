package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Data.Model.PlaceEntity
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface PlaceRepository {
    suspend fun savePlace(place: PlaceEntity)

    fun getPlaces(): Flow<List<PlaceEntity>>

    fun getPlaceDetails(placeId: String): Flow<PlaceEntity?>

    suspend fun getNearbyPlaces(location: String, radius: Int, type: String): Flow<List<Place>>
}
