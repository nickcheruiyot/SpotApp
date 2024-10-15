package com.example.spotapp.Domain.UseCase

import com.example.spotapp.Data.Model.TipEntity
import com.example.spotapp.Data.Repository.TipRepository
import javax.inject.Inject

class AddTipUseCase @Inject constructor(
    private val tipRepository: TipRepository
) {
    suspend fun execute(tip: TipEntity) {
        tipRepository.addTip(tip)
    }
}