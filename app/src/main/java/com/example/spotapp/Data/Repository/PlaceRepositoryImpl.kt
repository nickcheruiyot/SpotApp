package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Data.Model.PlaceEntity
import com.example.spotapp.Data.Remote.PlaceApiService
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class PlaceRepositoryImpl @Inject constructor(
    private val placeDao: PlaceDao,
    private val placeApiService: PlaceApiService // Injecting PlaceApiService
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

    override suspend fun getPlacesByCategory(category: String, location: String, radius: Int): Flow<List<Place>> {
        return flow {
            val response = placeApiService.getNearbyPlaces(location, radius, category)
            if (response.isSuccessful) {
                response.body()?.let { places ->
                    emit(places.results)
                }
            } else {
                throw Exception("Failed to fetch places for category: $category")
            }
        }
    }

    override suspend fun getNearbyPlaces(location: String, radius: Int, type: String): Flow<List<Place>> {
        return flow {
            val response = placeApiService.getNearbyPlaces(location, radius, type)
            if (response.isSuccessful) {
                response.body()?.let { placeResponse ->
                    emit(placeResponse.results)
                }
            } else {
                throw Exception("Failed to fetch nearby places")
            }
        }
    }

    override fun getSavedPlaces(): Flow<List<Place>> {
        return placeDao.getSavedPlaces()
    }

    override suspend fun ratePlace(placeId: String, rating: String) {
        // Retrieve the place entity from the database
        val placeEntity = placeDao.getPlaceById(placeId).first() // Collecting the Flow

        // Update the rating field of the place entity
        placeEntity?.let {
            // Create an updated PlaceEntity with the new rating
            val updatedPlaceEntity = it.copy(rating = rating)
            // Update the place entity in the database
            placeDao.updatePlace(updatedPlaceEntity)
        }
    }

    override fun getRatedPlaces(): Flow<List<Place>> {
        return placeDao.getRatedPlaces() // Assuming a DAO function exists for this
    }
}
