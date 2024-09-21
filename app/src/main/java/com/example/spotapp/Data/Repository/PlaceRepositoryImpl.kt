package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Remote.PlaceApiService
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaceRepositoryImpl(
    private val placeApiService: PlaceApiService
) : PlaceRepository {

    override suspend fun getNearbyPlaces(location: String, radius: Int, type: String): Flow<List<Place>> {
        return flow {
            val response = placeApiService.getNearbyPlaces(location, radius, type)
            if (response.isSuccessful) {
                response.body()?.let { places ->
                    emit(places.results)  // Assuming API returns a "results" list of Place objects
                }
            } else {
                throw Exception("Failed to fetch nearby places")
            }
        }
    }

    override suspend fun getPlaceDetails(placeId: String): Flow<Place> {
        return flow {
            val response = placeApiService.getPlaceDetails(placeId)
            if (response.isSuccessful) {
                response.body()?.let { place ->
                    emit(place)
                }
            } else {
                throw Exception("Failed to fetch place details")
            }
        }
    }
}