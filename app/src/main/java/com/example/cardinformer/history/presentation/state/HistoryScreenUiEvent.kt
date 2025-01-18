package com.example.cardinformer.history.presentation.state

import com.example.cardinformer.core.domain.model.CardInf

sealed interface HistoryScreenUiEvent {

    data class OnDeleteLongClick(val cardInf: CardInf) : HistoryScreenUiEvent
}