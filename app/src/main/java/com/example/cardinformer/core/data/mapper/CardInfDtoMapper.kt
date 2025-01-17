package com.example.cardinformer.core.data.mapper

import com.example.cardinformer.core.data.dto.CardInfResponse
import com.example.cardinformer.core.domain.model.CardInf

fun Result<CardInfResponse>.toCardInf(): Result<CardInf> {
    val cardInfResponse = this.getOrNull()
    return if (cardInfResponse != null) {
        Result.success(
            CardInf(
                numberLength = cardInfResponse.number.length,
                luhn = cardInfResponse.number.luhn,
                scheme = cardInfResponse.scheme,
                type = cardInfResponse.type,
                brand = cardInfResponse.brand,
                prepaid = cardInfResponse.prepaid,
                countryNumeric = cardInfResponse.country.numeric,
                countryAlpha2 = cardInfResponse.country.alpha2,
                countryName = cardInfResponse.country.name,
                countryEmoji = cardInfResponse.country.emoji,
                countryCurrency = cardInfResponse.country.currency,
                countryLatitude = cardInfResponse.country.latitude,
                countryLongitude = cardInfResponse.country.longitude,
                bankName = cardInfResponse.bank.name,
                bankUrl = cardInfResponse.bank.url,
                bankPhone = cardInfResponse.bank.phone,
                bankCity = cardInfResponse.bank.city
            )
        )
    } else {
        Result.failure(Exception("CardInfResponse is null"))
    }
}