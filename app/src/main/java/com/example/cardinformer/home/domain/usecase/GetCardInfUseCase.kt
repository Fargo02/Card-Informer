package com.example.cardinformer.home.domain.usecase

import com.example.cardinformer.core.domain.model.CardInf

interface GetCardInfUseCase {
    suspend operator fun invoke(bin: String): Result<CardInf>
}