package com.example.cardinformer.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinformer.R
import com.example.cardinformer.core.domain.model.CardInf
import com.example.cardinformer.core.utils.NetworkError
import com.example.cardinformer.core.utils.debounce
import com.example.cardinformer.home.domain.usecase.GetCardInfUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCardInfUseCase: GetCardInfUseCase
) : ViewModel() {

    private var lastExpression = ""

    private val _uiState = MutableStateFlow<HomeScreenUiState>(HomeScreenUiState.Start)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    private val _inputError = MutableStateFlow(false)
    val inputError: StateFlow<Boolean> = _inputError.asStateFlow()

    private val searchDebounceAction: (String) -> Unit = debounce(
        delayMillis = 2_000L,
        coroutineScope = viewModelScope,
        useLastParam = true
    ) { changedText ->
        when {
            changedText.length < 6 -> {
                _inputError.value = true
                _uiState.value = HomeScreenUiState.Error(R.string.enter_the_first_6_8_digits)
            }

            changedText != lastExpression -> {
                _inputError.value = false
                lastExpression = changedText
                getCardInformation(changedText)
            }
        }
    }

    fun searchDebounce(expression: String) {
        if (expression.isBlank()) {
            clearSearch()
            _inputError.value = false
        } else {
            searchDebounceAction(expression)
        }
    }

    private fun clearSearch() {
        lastExpression = ""
        _uiState.value = HomeScreenUiState.Start
    }

    fun getCardInformation(bin: String) = viewModelScope.launch(Dispatchers.Main) {
        _uiState.value = HomeScreenUiState.Loading
        val result: Result<CardInf> = getCardInfUseCase(bin.replace("\\s".toRegex(), ""))
        val newState = when (result.exceptionOrNull()) {
            is NetworkError.ServerError -> HomeScreenUiState.Error(R.string.server_error)
            is NetworkError.NoData -> HomeScreenUiState.Start
            is NetworkError.NoInternet -> HomeScreenUiState.NoInternet
            else -> result.getOrNull()?.let {
                HomeScreenUiState.Content(it)
            } ?: HomeScreenUiState.Start
        }
        _uiState.value = newState
    }
}