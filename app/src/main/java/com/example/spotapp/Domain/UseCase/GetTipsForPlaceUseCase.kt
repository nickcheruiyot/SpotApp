package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Model.TipEntity
import com.example.spotapp.Data.Repository.TipRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTipsForPlaceUseCase @Inject constructor(
    private val tipRepository: TipRepository
) {
    fun execute(placeId: String): Flow<List<TipEntity>> {
        return tipRepository.getTipsForPlace(placeId)
    }
}