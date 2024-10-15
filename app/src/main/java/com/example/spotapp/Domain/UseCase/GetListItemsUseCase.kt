package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.ListRepository
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListItemsUseCase @Inject constructor(
    private val repository: ListRepository
) {

    fun getSavedPlaces(): Flow<List<Place>> {
        return repository.getSavedPlaces()
    }

    fun getLikedPlaces(): Flow<List<Place>> {
        return repository.getLikedPlaces()
    }

    suspend fun createNewList(name: String, places: List<Place>) {
        repository.createNewList(name, places)
    }
}
