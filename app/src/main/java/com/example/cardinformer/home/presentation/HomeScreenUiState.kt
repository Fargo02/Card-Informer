package com.example.cardinformer.home.presentation

import com.example.cardinformer.core.domain.model.CardInf

sealed interface HomeScreenUiState {
    data object Start: HomeScreenUiState
    data object Error: HomeScreenUiState
    data object Loading: HomeScreenUiState
    data object NoInternet: HomeScreenUiState
    data class Content(val card: CardInf): HomeScreenUiState
}