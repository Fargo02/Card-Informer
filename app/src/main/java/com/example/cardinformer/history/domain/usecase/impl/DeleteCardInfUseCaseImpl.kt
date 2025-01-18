package com.example.cardinformer.history.domain.usecase.impl

import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.LocalDataSourceRepository
import com.example.cardinformer.history.domain.usecase.DeleteCardInfUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteCardInfUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
) : DeleteCardInfUseCase {

    override suspend fun invoke(cardInf: CardInf) =
        withContext(Dispatchers.IO) {
            localDataSourceRepository.delete(cardInf)
        }
}