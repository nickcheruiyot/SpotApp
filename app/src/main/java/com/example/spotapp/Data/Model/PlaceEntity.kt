package com.example.spotapp.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.spotapp.Data.Local.Database.Converters
import com.example.spotapp.Domain.Model.Location
import com.example.spotapp.Domain.Model.Place


@Entity(tableName = "places")
data class PlaceEntity(
    @PrimaryKey val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val rating: Double,
    val types: List<String>,
    val isSaved: Boolean = false,
    val isLiked: Boolean = false
)




