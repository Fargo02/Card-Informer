package com.example.cardinformer.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cardinformer.R
import com.example.cardinformer.core.composables.BankInfoSection
import com.example.cardinformer.core.composables.CardInfoSection
import com.example.cardinformer.core.composables.CountryInfoSection
import com.example.cardinformer.core.composables.SectionTitle
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
        SectionTitle(titleRes = R.string.card_info_title)
        CardInfoSection(card = card)

        Spacer(modifier = Modifier.height(8.dp))

        SectionTitle(titleRes = R.string.country_info_title)
        CountryInfoSection(card = card)

        Spacer(modifier = Modifier.height(8.dp))

        SectionTitle(titleRes = R.string.bank_info_title)
        BankInfoSection(card = card)
    }
}

