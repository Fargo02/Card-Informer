package com.example.cardinformer.core.data.source.local

import com.example.cardinformer.core.data.mapper.toCardInf
import com.example.cardinformer.core.data.mapper.toCardInfEntity
import com.example.cardinformer.core.data.source.local.dao.CardInfHistoryDao
import com.example.cardinformer.core.domain.model.CardInf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(
    private val cardInfHistoryDao: CardInfHistoryDao
) : LocalDataSource {

    override fun getAllCardInf(): Flow<List<CardInf>> {
        return cardInfHistoryDao.getAllCardInf().map { cardInfEntityList ->
            cardInfEntityList.map { cardInfEntity -> cardInfEntity.toCardInf() }
        }
    }

    override fun getCardInfByBin(bin: Int): Flow<CardInf> {
        return cardInfHistoryDao.getCardInfByBin(bin).map { cardInfEntity ->
            cardInfEntity.toCardInf()
        }
    }

    override suspend fun addCardInf(cardInf: CardInf) {
        cardInfHistoryDao.addCardInf(cardInf.toCardInfEntity())
    }

    override suspend fun updateCardInf(cardInf: CardInf) {
        cardInfHistoryDao.updateCardInf(cardInf.toCardInfEntity())
    }

    override suspend fun delete(cardInf: CardInf) {
        cardInfHistoryDao.updateCardInf(cardInf.toCardInfEntity())
    }
}