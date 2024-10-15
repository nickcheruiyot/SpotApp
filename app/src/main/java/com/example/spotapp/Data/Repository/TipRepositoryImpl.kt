package com.example.spotapp.Data.Repository

import com.example.spotapp.Data.Local.TipDao
import com.example.spotapp.Data.Model.TipEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TipRepositoryImpl @Inject constructor(
    private val tipDao: TipDao
) : TipRepository {
    override suspend fun addTip(tip: TipEntity) {
        tipDao.insertTip(tip)
    }

    override fun getTipsForPlace(placeId: String): Flow<List<TipEntity>> {
        return tipDao.getTipsForPlace(placeId)
    }
}