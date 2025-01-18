@file:OptIn(ExperimentalFoundationApi::class)

package com.example.cardinformer.history.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinformer.R
import com.example.cardinformer.core.composables.BankInfoSection
import com.example.cardinformer.core.composables.CardInfoSection
import com.example.cardinformer.core.composables.CountryInfoSection
import com.example.cardinformer.core.composables.InfoRow
import com.example.cardinformer.core.composables.SectionTitle
import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.history.presentation.state.HistoryScreenUiState
import com.example.cardinformer.ui.theme.CardInformerTheme

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    uiState: HistoryScreenUiState,
    onDeleteCardInfLongClick: (CardInf) -> Unit,
) {
    when (uiState) {
        is HistoryScreenUiState.Empty -> {
            HistoryScreenEmpty(modifier = modifier)
        }

        is HistoryScreenUiState.Content -> {
            HistoryScreenContent(
                modifier = modifier,
                cardList = uiState.card,
                onDeleteCardInfLongClick = onDeleteCardInfLongClick
            )
        }
    }
}

@Composable
fun HistoryScreenEmpty(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.history_is_empty),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}

@Composable
fun HistoryScreenContent(
    modifier: Modifier = Modifier,
    cardList: List<CardInf>,
    onDeleteCardInfLongClick: (CardInf) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(cardList) { card ->
            ExpandableCard(
                card = card,
                onDeleteCardInfLongClick = onDeleteCardInfLongClick
            )
        }
    }
}

@Composable
fun ExpandableCard(
    modifier: Modifier = Modifier,
    card: CardInf,
    onDeleteCardInfLongClick: (CardInf) -> Unit,
) {

    var expanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .combinedClickable(
                onClick = { expanded = !expanded },
                onLongClick = { onDeleteCardInfLongClick(card) }
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SectionTitle(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                titleRes = R.string.card_info_title
            )
            InfoRow(labelRes = R.string.bin, value = card.bin)
            CardInfoSection(card = card)

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    SectionTitle(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        titleRes = R.string.country_info_title
                    )
                    CountryInfoSection(card = card)

                    Spacer(modifier = Modifier.height(8.dp))

                    SectionTitle(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        titleRes = R.string.bank_info_title
                    )
                    BankInfoSection(card = card)
                }
            }

            Icon(
                imageVector = if (expanded) {
                    Icons.Default.KeyboardArrowDown
                } else
                    Icons.Default.KeyboardArrowUp,
                contentDescription = if (expanded) {
                    stringResource(R.string.collapse)
                } else stringResource(
                    R.string.expand
                ),
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHistoryScreen() {

    CardInformerTheme(dynamicColor = false) {
        val contentState: HistoryScreenUiState = HistoryScreenUiState.Content(
            card = listOf(
                CardInf(
                    bin = 1233.toString(),
                    numberLength = null,
                    luhn = false,
                    scheme = "null",
                    type = "null",
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
                ),
                CardInf(
                    bin = 1233.toString(),
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
        )

        Column {
            HistoryScreen(uiState = contentState, onDeleteCardInfLongClick = { })
        }
    }
}