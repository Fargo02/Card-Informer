package com.example.cardinformer.core.domain.repository

import com.example.cardinformer.core.domain.model.CardInf
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceRepository {

    fun getAllCardInf(): Flow<List<CardInf>>

    fun getCardInfByBin(bin: Int): Flow<CardInf>

    suspend fun addCardInf(cardInf: CardInf)

    suspend fun updateCardInf(cardInf: CardInf)

    suspend fun delete(cardInf: CardInf)
}