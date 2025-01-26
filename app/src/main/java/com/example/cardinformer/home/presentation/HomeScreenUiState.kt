package com.example.cardinformer.home.presentation

import androidx.annotation.StringRes
import com.example.cardinformer.core.domain.model.CardInf

sealed interface HomeScreenUiState {
    data object Start: HomeScreenUiState
    data class Error(@StringRes val messageId: Int): HomeScreenUiState
    data object Loading: HomeScreenUiState
    data object NoInternet: HomeScreenUiState
    data class Content(val card: CardInf): HomeScreenUiState
}