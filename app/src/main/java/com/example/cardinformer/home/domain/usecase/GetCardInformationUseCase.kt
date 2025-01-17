package com.example.cardinformer.home.domain.usecase

import com.example.cardinformer.core.domain.CardInformation

interface GetCardInformationUseCase {
    operator fun invoke(bin: String): Result<CardInformation>
}