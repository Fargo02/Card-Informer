package com.example.cardinformer.core.domain.repository

import com.example.cardinformer.core.domain.model.CardInf

interface CardInfRepository {

    suspend fun getCardInf(bin: String): Result<CardInf>
}