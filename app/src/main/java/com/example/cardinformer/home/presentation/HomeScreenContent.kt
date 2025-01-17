package com.example.cardinformer.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cardinformer.R
import com.example.cardinformer.core.composables.TextItem
import com.example.cardinformer.core.domain.model.CardInf

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    card: CardInf
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.card_info_title),
            style = MaterialTheme.typography.headlineMedium
        )

        TextItem(
            label = stringResource(R.string.number_length),
            value = card.numberLength?.toString() ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.luhn_check),
            value = if (card.luhn) stringResource(R.string.yes) else stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.scheme),
            value = card.scheme ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.type),
            value = card.type ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.brand),
            value = card.brand ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.prepaid),
            value = if (card.prepaid) stringResource(R.string.yes) else stringResource(R.string.no)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.country_info_title),
            style = MaterialTheme.typography.headlineSmall
        )

        TextItem(
            label = stringResource(R.string.country_numeric),
            value = card.countryNumeric ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.country_code),
            value = card.countryAlpha2 ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.country_name),
            value = card.countryName ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.country_emoji),
            value = card.countryEmoji ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.currency),
            value = card.countryCurrency ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.latitude),
            value = card.countryLatitude?.toString() ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.longitude),
            value = card.countryLongitude?.toString() ?: stringResource(R.string.no)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.bank_info_title),
            style = MaterialTheme.typography.headlineSmall
        )

        TextItem(
            label = stringResource(R.string.bank_name),
            value = card.bankName ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.bank_url),
            value = card.bankUrl ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.bank_phone),
            value = card.bankPhone ?: stringResource(R.string.no)
        )
        TextItem(
            label = stringResource(R.string.bank_city),
            value = card.bankCity ?: stringResource(R.string.no)
        )
    }
}