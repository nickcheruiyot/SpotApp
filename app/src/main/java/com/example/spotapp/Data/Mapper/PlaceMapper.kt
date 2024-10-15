package com.example.spotapp.Data.Mapper

import com.example.spotapp.Data.Model.PlaceEntity
import com.example.spotapp.Domain.Model.Location
import com.example.spotapp.Domain.Model.Place


object PlaceMapper {
    fun PlaceEntity.toPlace(): Place {
        return Place(
            id = id,
            name = name,
            location = Location(latitude, longitude),
            address = address,
            rating = rating,
            types = types,
            isSaved = isSaved,
            isLiked = isLiked
        )
    }

    fun Place.toEntity(): PlaceEntity {
        return PlaceEntity(
            id = id,
            name = name,
            latitude = location.lat,
            longitude = location.lng,
            address = address,
            rating = rating,
            types = types,
            isSaved = isSaved,
            isLiked = isLiked
        )
    }
}
