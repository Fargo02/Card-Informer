package com.example.cardinformer.history.domain.usecase

import com.example.cardinformer.core.domain.model.CardInf

interface DeleteCardInfUseCase {

    suspend operator fun invoke(cardInf: CardInf)
}