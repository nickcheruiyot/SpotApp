package com.example.spotapp.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spotapp.Data.Model.TipEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TipDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTip(tip: TipEntity)

    @Query("SELECT * FROM tips WHERE placeId = :placeId ORDER BY timestamp DESC")
    fun getTipsForPlace(placeId: String): Flow<List<TipEntity>>
}
