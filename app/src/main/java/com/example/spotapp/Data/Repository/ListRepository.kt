package com.example.spotapp.Data.Repository

import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
interface ListRepository {
    // Function to get saved places
    fun getSavedPlaces(): Flow<List<Place>>

    // Removed the function to get liked places

    // Function to create a new list
    suspend fun createNewList(name: String, places: List<Place>)

    // Function to add a place to a list
    suspend fun addPlaceToList(listName: String, place: Place)


    // New function to rate a place
    suspend fun ratePlace(place: Place, rating: String)  // Function to rate a place
}
