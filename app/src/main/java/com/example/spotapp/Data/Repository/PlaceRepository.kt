package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Data.Model.PlaceEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaceRepository @Inject constructor(private val placeDao: PlaceDao) {suspend fun savePlace(place: PlaceEntity) {
    placeDao.insertPlace(place)
}

    fun getPlaces(): Flow<List<PlaceEntity>> = placeDao.getAllPlaces()

}