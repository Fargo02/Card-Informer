package com.example.cardinformer.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinformer.core.composables.TextItem
import com.example.cardinformer.core.domain.model.CardInf

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    card: CardInf
) {
    val groupedFields = listOf(
        "Card Information" to listOf(
            "Number Length" to card.numberLength.toString(),
            "Luhn Check" to if (card.luhn) "Yes" else "No",
            "Scheme" to card.scheme,
            "Type" to card.type,
            "Brand" to card.brand,
            "Prepaid" to if (card.prepaid) "Yes" else "No"
        ),
        "Country Information" to listOf(
            "Country Numeric" to card.countryNumeric,
            "Country Code" to card.countryAlpha2,
            "Country Name" to card.countryName,
            "Country Emoji" to card.countryEmoji,
            "Currency" to card.countryCurrency,
            "Latitude" to card.countryLatitude.toString(),
            "Longitude" to card.countryLongitude.toString()
        ),
        "Bank Information" to listOf(
            "Bank Name" to card.bankName,
            "Bank URL" to card.bankUrl,
            "Bank Phone" to card.bankPhone,
            "Bank City" to card.bankCity
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        groupedFields.forEach { (title, fields) ->
            Text(text = title, style = MaterialTheme.typography.headlineSmall)
            fields.forEach { (label, value) ->
                TextItem(label = label, value = value)
            }
        }
    }
}