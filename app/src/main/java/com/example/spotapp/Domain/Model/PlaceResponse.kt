package com.example.spotapp.Domain.Model

data class PlaceResponse(
    val results: List<Place>,
    val status: String,  // e.g., "OK" or "ERROR"
    val errorMessage: String? = null,  // For error responses, if any
    val nextPageToken: String? = null  // For pagination, if the API supports it
)

