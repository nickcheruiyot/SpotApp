package com.example.spotapp.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tips")
data class TipEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val placeId: String,
    val userId: String,
    val username: String,     // New field to store the username
    val content: String,
    val timestamp: Long
)
