package com.example.spotapp.Domain.Model

import com.google.android.gms.maps.model.LatLng

data class Place(
    val id: String,
    val name: String,
    val location: Location,
    val rating: Double,
    val types: List<String>
)

data class Location(
    val lat: Double,
    val lng: Double
)
