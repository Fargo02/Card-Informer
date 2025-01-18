package com.example.cardinformer.history.domain.usecase

import com.example.cardinformer.core.domain.model.CardInf
import kotlinx.coroutines.flow.Flow

interface GetAllCardInfUseCase {

    operator fun invoke(): Flow<List<CardInf>>
}