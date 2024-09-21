package com.example.spotapp.Data.Remote

import com.example.spotapp.Domain.Model.Place
import com.example.spotapp.Domain.Model.PlaceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceApiService {

    @GET("maps/api/place/nearbysearch/json")
    suspend fun getNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String,
        @Query("key") apiKey: String // API key for Google Places API
    ): Response<PlaceResponse>

    @GET("maps/api/place/details/json")
    suspend fun getPlaceDetails(
        @Query("place_id") placeId: String,
        @Query("key") apiKey: String
    ): Response<Place>
}