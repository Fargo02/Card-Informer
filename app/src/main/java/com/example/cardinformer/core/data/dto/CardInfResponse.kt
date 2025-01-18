package com.example.cardinformer.core.data.dto

class CardInfResponse(
    val bank: BankDto?,
    val brand: String?,
    val country: CountryDto?,
    val number: NumberDto?,
    val prepaid: Boolean,
    val scheme: String?,
    val type: String?
)