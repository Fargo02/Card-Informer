package com.example.cardinformer.home.domain.usecase.impl

import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.CardInfRepository
import com.example.cardinformer.home.domain.usecase.GetCardInfUseCase
import javax.inject.Inject

class GetCardInfUseCaseImpl @Inject constructor(
    private val cardInfRepository: CardInfRepository
) : GetCardInfUseCase {

    override suspend operator fun invoke(bin: String): Result<CardInf> {
        //return cardInfRepository.getCardInf(bin)
        return Result.success(
            CardInf(
                numberLength = null,
                luhn = false,
                scheme = null,
                type = null,
                brand = null,
                prepaid = false,
                countryNumeric = null,
                countryAlpha2 = null,
                countryName = null,
                countryEmoji = null,
                countryCurrency = null,
                countryLatitude = null,
                countryLongitude = null,
                bankName = null,
                bankUrl = null,
                bankPhone = null,
                bankCity = null

            )
        )
    }
}