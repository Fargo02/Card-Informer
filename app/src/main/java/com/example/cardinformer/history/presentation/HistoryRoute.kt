package com.example.cardinformer.history.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cardinformer.history.presentation.state.HistoryScreenUiEvent

@Composable
fun HistoryRoute(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HistoryScreen(
        modifier = modifier,
        uiState = uiState,
        onDeleteCardInfLongClick = {
            viewModel.handleEvent(
                HistoryScreenUiEvent.OnDeleteLongClick(it)
            )
        }
    )
}