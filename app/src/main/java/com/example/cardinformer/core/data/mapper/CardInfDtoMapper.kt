package com.example.cardinformer.core.data.mapper

import com.example.cardinformer.core.data.dto.CardInfResponse
import com.example.cardinformer.core.domain.model.CardInf

fun CardInfResponse.toCardInf(bin: String) = CardInf(
    bin = bin,
    numberLength = this.number?.length,
    luhn = this.number?.luhn ?: false,
    scheme = this.scheme,
    type = this.type,
    brand = this.brand,
    prepaid = this.prepaid,
    countryNumeric = this.country?.numeric,
    countryAlpha2 = this.country?.alpha2,
    countryName = this.country?.name,
    countryEmoji = this.country?.emoji,
    countryCurrency = this.country?.currency,
    countryLatitude = this.country?.latitude,
    countryLongitude = this.country?.longitude,
    bankName = this.bank?.name,
    bankUrl = this.bank?.url,
    bankPhone = this.bank?.phone,
    bankCity = this.bank?.city
)