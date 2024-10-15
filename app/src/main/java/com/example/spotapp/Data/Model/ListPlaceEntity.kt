package com.example.spotapp.Data.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "list_places",
    foreignKeys = [
        ForeignKey(
            entity = PlaceEntity::class,
            parentColumns = ["id"],
            childColumns = ["placeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ListPlaceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val listName: String,
    val placeId: String
)
