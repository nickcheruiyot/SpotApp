package com.example.spotapp.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.spotapp.Data.Mapper.PlaceMapper.toPlace
import com.example.spotapp.Data.Model.ListPlaceEntity
import com.example.spotapp.Data.Model.PlaceEntity
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface PlaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(place: PlaceEntity)

    @Query("SELECT * FROM places")
    fun getAllPlaces(): Flow<List<PlaceEntity>>

    @Query("SELECT * FROM places WHERE id = :placeId LIMIT 1")
    fun getPlaceById(placeId: String): Flow<PlaceEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlaces(places: List<PlaceEntity>)

    @Query("SELECT * FROM places WHERE isSaved = 1")
    fun getSavedPlaces(): Flow<List<PlaceEntity>>

    // New function to return saved places as Place objects
    @Query("SELECT * FROM places WHERE isSaved = 1")
    fun getSavedPlacesMapped(): Flow<List<Place>> {
        return getSavedPlaces().map { entities ->
            entities.map { it.toPlace() } // Map PlaceEntity to Place
        }
    }

    // Function to update rating of a place
    @Query("UPDATE places SET rating = :rating WHERE id = :placeId")
    suspend fun updateRating(placeId: String, rating: String)

    // Insert a place into a list
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlaceToList(listEntity: ListPlaceEntity)

    @Query("SELECT * FROM places INNER JOIN list_places ON places.id = list_places.placeId WHERE list_places.listName = :listName")
    fun getPlacesByList(listName: String): Flow<List<PlaceEntity>>

    // Optional: Get a list of rated places
    @Query("SELECT * FROM places WHERE rating IS NOT NULL")
    fun getRatedPlaces(): Flow<List<PlaceEntity>>
    @Update
    suspend fun updatePlace(placeEntity: PlaceEntity) // Update method to save changes
}



