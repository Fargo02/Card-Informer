package com.example.cardinformer.home.presentation

import com.example.cardinformer.core.domain.CardInformation

sealed interface HomeScreenUiState {
    data object Empty: HomeScreenUiState
    data object Error: HomeScreenUiState
    data object NoInternet: HomeScreenUiState
    data class Content(val card: CardInformation): HomeScreenUiState
}