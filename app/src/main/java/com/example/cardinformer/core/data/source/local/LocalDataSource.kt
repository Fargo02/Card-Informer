package com.example.cardinformer.core.data.source.local

import com.example.cardinformer.core.domain.model.CardInf
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllCardInf(): Flow<List<CardInf>>

    fun getCardInfByBin(bin: Int): Flow<CardInf>

    suspend fun addCardInf(cardInf: CardInf)

    suspend fun updateCardInf(cardInf: CardInf)

    suspend fun delete(cardInf: CardInf)
}