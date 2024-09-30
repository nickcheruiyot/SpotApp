package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Data.Model.PlaceEntity
import com.example.spotapp.Data.Remote.PlaceApiService
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val placeDao: PlaceDao,
    private val placeApiService: PlaceApiService
) : PlaceRepository {

    override suspend fun savePlace(place: PlaceEntity) {
        placeDao.insertPlace(place)
    }

    override fun getPlaces(): Flow<List<PlaceEntity>> {
        return placeDao.getAllPlaces()
    }

    override fun getPlaceDetails(placeId: String): Flow<PlaceEntity?> {
        return placeDao.getPlaceById(placeId)
    }

    override suspend fun getNearbyPlaces(location: String, radius: Int, type: String): Flow<List<Place>> {
        return flow {
            val response = placeApiService.getNearbyPlaces(location, radius, type)
            if (response.isSuccessful) {
                response.body()?.let { placeResponse ->
                    emit(placeResponse.results)  // Assuming the API response has a "results" field.
                }
            } else {
                throw Exception("Failed to fetch nearby places")
            }
        }
    }
}