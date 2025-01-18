package com.example.cardinformer.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.utils.debounce
import com.example.cardinformer.history.domain.usecase.DeleteCardInfUseCase
import com.example.cardinformer.history.domain.usecase.GetAllCardInfUseCase
import com.example.cardinformer.history.presentation.state.HistoryScreenUiEvent
import com.example.cardinformer.history.presentation.state.HistoryScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val deleteCardInfUseCase: DeleteCardInfUseCase,
    getAllCardInfUseCase: GetAllCardInfUseCase
) : ViewModel() {

    fun handleEvent(event: HistoryScreenUiEvent) {
        when (event) {
            is HistoryScreenUiEvent.OnDeleteLongClick -> searchDebounceAction(event.cardInf)
        }
    }

    private val cards = getAllCardInfUseCase()

    val uiState: StateFlow<HistoryScreenUiState> = cards.map { cardInfList ->
        if (cardInfList.isNotEmpty())
            HistoryScreenUiState.Content(cardInfList.reversed())
        else HistoryScreenUiState.Empty
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HistoryScreenUiState.Empty
    )

    private val searchDebounceAction: (CardInf) -> Unit = debounce(
        coroutineScope = viewModelScope,
        useLastParam = true
    ) { cardInf -> deleteCardInf(cardInf) }

    private fun deleteCardInf(cardInf: CardInf) {
        viewModelScope.launch {
            deleteCardInfUseCase(cardInf)
        }
    }
}