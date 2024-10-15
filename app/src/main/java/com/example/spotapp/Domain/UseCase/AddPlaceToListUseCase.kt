package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Repository.ListRepository
import com.example.spotapp.Domain.Model.Place
import javax.inject.Inject

class AddPlaceToListUseCase @Inject constructor(
    private val repository: ListRepository  // Inject the repository to handle the operation
) {
    // Ensure that this function matches your call in PlaceViewModel
    suspend fun execute(place: Place) {
        repository.addPlaceToList(place)  // Call the repository function to add place to the list
    }
}

