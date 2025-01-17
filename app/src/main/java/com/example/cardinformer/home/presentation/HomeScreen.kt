package com.example.cardinformer.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.cardinformer.core.composables.TopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState,
    navToHistory: () -> Unit,
    getInformation: (String) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                modifier = Modifier.shadow(4.dp),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
//            when(uiState) {
//                is HomeScreenUiState.Empty -> HomeScreenEmpty()
//                is HomeScreenUiState.Error -> HomeScreenError()
//                is HomeScreenUiState.Content -> HomeScreenContent(
//                    Card = uiState.card,
//                )
//            }
        }
    }
}