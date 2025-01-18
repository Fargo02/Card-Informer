package com.example.cardinformer.core.data.repository

import com.example.cardinformer.core.data.mapper.toCardInf
import com.example.cardinformer.core.data.network.CardInfNetworkClient
import com.example.cardinformer.core.data.source.local.LocalDataSource
import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.CardInfRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardInfRepositoryImpl @Inject constructor(
    private val cardInfNetworkClient: CardInfNetworkClient,
    private val localDataSource: LocalDataSource
) : CardInfRepository {

    override suspend fun getCardInf(bin: String): Result<CardInf> =
        withContext(Dispatchers.IO) {
            cardInfNetworkClient.execute(bin)
                .fold(
                    onSuccess = { cardInf ->
                        val res = cardInf.toCardInf(bin)
                        localDataSource.addCardInf(res)
                        Result.success(res)
                    },
                    onFailure = { error ->
                        Result.failure(error)
                    }
                )
        }
}