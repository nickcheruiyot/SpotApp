package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Model.TipEntity
import kotlinx.coroutines.flow.Flow

interface TipRepository {
    suspend fun addTip(tip: TipEntity)
    fun getTipsForPlace(placeId: String): Flow<List<TipEntity>>
}