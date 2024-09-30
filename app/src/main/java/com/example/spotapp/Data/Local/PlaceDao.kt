package com.example.spotapp.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotapp.Data.Model.PlaceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(place: PlaceEntity)

    @Query("SELECT * FROM places")
    fun getAllPlaces(): Flow<List<PlaceEntity>>

    @Query("SELECT * FROM places WHERE id = :placeId LIMIT 1")
    fun getPlaceById(placeId: String): Flow<PlaceEntity?>

    // Optional: Insert multiple places (if caching nearby places locally)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlaces(places: List<PlaceEntity>)
}