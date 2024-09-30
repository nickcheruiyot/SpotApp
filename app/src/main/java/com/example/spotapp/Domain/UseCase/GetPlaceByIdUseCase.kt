package com.example.spotapp.Domain.UseCase



import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Domain.Model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class GetPlaceByIdUseCase @Inject constructor(
    private val repository: PlaceRepository
) {
    suspend fun execute(placeId: String): Flow<Place?> {
        // Only one return statement is needed here.
        return repository.getPlaceDetails(placeId)
    }
}