package com.example.cardinformer.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinformer.core.domain.CardInformation
import com.example.cardinformer.core.utils.NetworkError
import com.example.cardinformer.home.domain.usecase.GetCardInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCardInformationUseCase: GetCardInformationUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenUiState>(HomeScreenUiState.Empty)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    var card: CardInformation = CardInformation()

    fun getCardInformation(bin: String) = viewModelScope.launch(Dispatchers.Main) {
        val result: Result<CardInformation> = getCardInformationUseCase(bin)
        val newState = when (result.exceptionOrNull()) {
            is NetworkError.ServerError -> HomeScreenUiState.Error
            is NetworkError.NoData -> HomeScreenUiState.Empty
            is NetworkError.NoInternet -> HomeScreenUiState.NoInternet
            else -> result.getOrNull()?.let {
                HomeScreenUiState.Content(it)
            } ?: HomeScreenUiState.Empty
        }
        _uiState.value = newState
    }
}