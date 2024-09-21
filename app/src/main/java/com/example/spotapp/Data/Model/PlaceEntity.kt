package com.example.spotapp.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")

data class PlaceEntity(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    val latitude: Double,
    val longitude: Double
)
