package com.example.cardinformer.core.data.mapper

import com.example.cardinformer.core.data.source.local.entity.CardInfEntity
import com.example.cardinformer.core.domain.model.CardInf

fun CardInfEntity.toCardInf() = CardInf(
    bin = bin.toString(),
    numberLength = numberLength,
    luhn = luhn,
    scheme = scheme,
    type = type,
    brand = brand,
    prepaid = prepaid,
    countryNumeric = countryNumeric,
    countryAlpha2 = countryAlpha2,
    countryName = countryName,
    countryEmoji = countryEmoji,
    countryCurrency = countryCurrency,
    countryLatitude = countryLatitude,
    countryLongitude = countryLongitude,
    bankName = bankName,
    bankUrl = bankUrl,
    bankPhone = bankPhone,
    bankCity = bankCity
)

fun CardInf.toCardInfEntity() = CardInfEntity(
    bin = bin.toInt(),
    numberLength = numberLength,
    luhn = luhn,
    scheme = scheme,
    type = type,
    brand = brand,
    prepaid = prepaid,
    countryNumeric = countryNumeric,
    countryAlpha2 = countryAlpha2,
    countryName = countryName,
    countryEmoji = countryEmoji,
    countryCurrency = countryCurrency,
    countryLatitude = countryLatitude,
    countryLongitude = countryLongitude,
    bankName = bankName,
    bankUrl = bankUrl,
    bankPhone = bankPhone,
    bankCity = bankCity
)