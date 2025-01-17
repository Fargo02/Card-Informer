package com.example.cardinformer.core.data

import com.example.cardinformer.core.data.mapper.toCardInf
import com.example.cardinformer.core.data.network.CardInfNetworkClient
import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.CardInfRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardInfRepositoryImpl @Inject constructor(
    private val cardInfNetworkClient: CardInfNetworkClient
) : CardInfRepository {

    override suspend fun getCardInf(): Result<CardInf> =
        withContext(Dispatchers.IO) {
            cardInfNetworkClient.execute().toCardInf()
        }
}