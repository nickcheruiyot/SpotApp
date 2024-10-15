package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Domain.Model.Location
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val placeDao: PlaceDao
) : ListRepository {

    override fun getSavedPlaces(): Flow<List<Place>> {
        return placeDao.getSavedPlaces().map { placeEntities ->
            placeEntities.map { placeEntity ->
                // Map PlaceEntity to Place
                Place(
                    id = placeEntity.id,
                    name = placeEntity.name,
                    location = Location(lat = placeEntity.latitude, lng = placeEntity.longitude), // Adjust accordingly
                    address = placeEntity.address,
                    rating = placeEntity.rating,
                    types = placeEntity.types,
                    isSaved = placeEntity.isSaved,
                    isLiked = placeEntity.isLiked // Ensure this field is present in PlaceEntity
                )
            }
        }
    }

    override suspend fun createNewList(name: String, places: List<Place>) {
        // Logic to create a new list
        // Implement this logic if you have a method for handling lists in your DAO
    }

    override suspend fun addPlaceToList(listName: String, place: Place) {
        // Insert place into a list in your DAO
        // This would require a method in your PlaceDao for adding places to a list
    }

    override suspend fun ratePlace(place: Place, rating: String) {
        // Update the place with the given rating
        placeDao.updateRating(place.id, rating) // Ensure this function exists in PlaceDao
    }
}


