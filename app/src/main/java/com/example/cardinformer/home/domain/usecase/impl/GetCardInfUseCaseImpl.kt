package com.example.cardinformer.home.domain.usecase.impl

import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.domain.repository.CardInfRepository
import com.example.cardinformer.home.domain.usecase.GetCardInfUseCase
import javax.inject.Inject

class GetCardInfUseCaseImpl @Inject constructor(
    private val cardInfRepository: CardInfRepository
) : GetCardInfUseCase {

    override suspend operator fun invoke(bin: String): Result<CardInf> {
        return cardInfRepository.getCardInf()
//        return Result.success(
//            CardInf(
//                numberLength = 2367,
//                luhn = false,
//                scheme = "dictas",
//                type = "utamur",
//                brand = "dico",
//                prepaid = false,
//                countryNumeric = "Spain",
//                countryAlpha2 = "Guinea-Bissau",
//                countryName = "Brazil",
//                countryEmoji = "Central African Republic",
//                countryCurrency = "Afghanistan",
//                countryLatitude = 4423,
//                countryLongitude = 2221,
//                bankName = "Haley Holland",
//                bankUrl = "https://www.google.com/#q=dignissim",
//                bankPhone = "(337) 364-7223",
//                bankCity = "Haddonfield"
//            )
//        )
    }
}