package com.example.cardinformer.history.presentation.state

import com.example.cardinformer.core.domain.model.CardInf

sealed interface HistoryScreenUiState {
    data object Empty: HistoryScreenUiState
    data class Content(val card: List<CardInf>): HistoryScreenUiState
}