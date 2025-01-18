package com.example.cardinformer.core.data.repository

import com.example.cardinformer.core.data.source.local.LocalDataSource
import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.LocalDataSourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : LocalDataSourceRepository {

    override fun getAllCardInf(): Flow<List<CardInf>> = localDataSource.getAllCardInf()

    override fun getCardInfByBin(bin: Int): Flow<CardInf> = localDataSource.getCardInfByBin(bin)

    override suspend fun addCardInf(cardInf: CardInf) = localDataSource.addCardInf(cardInf)

    override suspend fun updateCardInf(cardInf: CardInf) = localDataSource.updateCardInf(cardInf)

    override suspend fun delete(cardInf: CardInf) = localDataSource.delete(cardInf)
}