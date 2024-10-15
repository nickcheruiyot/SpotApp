package com.example.spotapp.Data.Local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Data.Model.ListPlaceEntity
import com.example.spotapp.Data.Model.PlaceEntity
import com.example.spotapp.Domain.Model.Place
@Database(entities = [PlaceEntity::class, ListPlaceEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)  // Include the Converters class here
abstract class AppDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}

