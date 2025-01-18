package com.example.cardinformer.core.composables

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cardinformer.R
import com.example.cardinformer.core.domain.model.CardInf

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
) {
    Text(
        modifier = modifier,
        text = stringResource(titleRes),
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun CardInfoSection(card: CardInf) {
    InfoRow(labelRes = R.string.number_length, value = card.numberLength?.toString())
    InfoRow(
        labelRes = R.string.luhn_check,
        value = if (card.luhn)
            stringResource(id = R.string.yes)
        else
            stringResource(id = R.string.no)
    )
    InfoRow(labelRes = R.string.scheme, value = card.scheme)
    InfoRow(labelRes = R.string.type, value = card.type)
    InfoRow(labelRes = R.string.brand, value = card.brand)
    InfoRow(
        labelRes = R.string.prepaid,
        value = if (card.prepaid)
            stringResource(id = R.string.yes)
        else
            stringResource(id = R.string.no)
    )
}

@Composable
fun CountryInfoSection(card: CardInf) {
    InfoRow(labelRes = R.string.country_numeric, value = card.countryNumeric)
    InfoRow(labelRes = R.string.country_code, value = card.countryAlpha2)
    InfoRow(labelRes = R.string.country_name, value = card.countryName)
    InfoRow(labelRes = R.string.country_emoji, value = card.countryEmoji)
    InfoRow(labelRes = R.string.currency, value = card.countryCurrency)
    InfoRow(labelRes = R.string.latitude, value = card.countryLatitude?.toString())
    InfoRow(labelRes = R.string.longitude, value = card.countryLongitude?.toString())
}

@Composable
fun BankInfoSection(card: CardInf) {
    InfoRow(labelRes = R.string.bank_name, value = card.bankName)
    InfoRow(labelRes = R.string.bank_url, value = card.bankUrl)
    InfoRow(labelRes = R.string.bank_phone, value = card.bankPhone)
    InfoRow(labelRes = R.string.bank_city, value = card.bankCity)
}