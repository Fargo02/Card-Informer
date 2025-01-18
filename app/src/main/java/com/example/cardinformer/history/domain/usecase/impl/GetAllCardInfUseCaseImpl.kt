package com.example.cardinformer.history.domain.usecase.impl

import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.LocalDataSourceRepository
import com.example.cardinformer.history.domain.usecase.GetAllCardInfUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCardInfUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): GetAllCardInfUseCase {

    override fun invoke(): Flow<List<CardInf>> = localDataSourceRepository.getAllCardInf()
}