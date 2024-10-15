package com.example.spotapp.Domain.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.spotapp.Data.Local.Database.Converters
import com.example.spotapp.Data.Model.PlaceEntity
import com.google.android.gms.maps.model.LatLng


data class Place(
    val id: String,
    val name: String,
    val location: Location,
    val address: String,
    val rating: Double,
    val types: List<String>,
    val isSaved: Boolean = false,
    val isLiked: Boolean = false
)

data class Location(
    val lat: Double,
    val lng: Double
)



