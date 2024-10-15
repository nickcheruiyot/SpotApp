package com.example.spotapp.Domain.Model

data class Tip(
    val id: String = "",        // Unique ID for the tip
    val placeId: String,        // ID of the place the tip is associated with
    val userId: String,         // ID of the user who added the tip
    val username: String,       // Username of the user who added the tip
    val content: String,        // Content of the tip
    val timestamp: Long = System.currentTimeMillis()  // Time when the tip was added
)

