package com.example.spotapp.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spotapp.Data.Model.PlaceEntity

@Database(entities = [PlaceEntity::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun placeDao(): PlaceDao
}