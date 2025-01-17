package com.example.cardinformer.home.domain.usecase.impl

import com.example.cardinformer.core.domain.CardInformation
import com.example.cardinformer.home.domain.usecase.GetCardInformationUseCase
import javax.inject.Inject

class GetCardInformationUseCaseImpl @Inject constructor(
): GetCardInformationUseCase {

    override operator fun invoke(bin: String): Result<CardInformation> {
        TODO("Not yet implemented")
    }
}