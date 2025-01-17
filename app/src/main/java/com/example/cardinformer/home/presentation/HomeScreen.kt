package com.example.cardinformer.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinformer.R
import com.example.cardinformer.core.composables.BasicButton
import com.example.cardinformer.core.composables.TextField
import com.example.cardinformer.core.composables.TopBar
import com.example.cardinformer.ui.theme.CardInformerTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState,
    navToHistory: () -> Unit,
    getInformation: (String) -> Unit
) {

    var binText by rememberSaveable { mutableStateOf("") }

    getInformation(binText)

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
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = binText,
                placeHolderText = "",
                singleLine = true,
                onValueChange = { newText -> binText = newText }
            )
            when (uiState) {
                is HomeScreenUiState.Empty -> HomeScreenEmpty()
                is HomeScreenUiState.Error -> HomeScreenError()
                is HomeScreenUiState.Loading -> HomeScreenLoading()
                is HomeScreenUiState.NoInternet -> HomeScreenNoInternet(
                    getInformation = getInformation,
                    bin = binText
                )

                is HomeScreenUiState.Content -> HomeScreenContent(card = uiState.card)
            }
        }
    }
}

@Composable
private fun HomeScreenEmpty(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize())
}

@Composable
private fun HomeScreenError(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Error",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun HomeScreenLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
private fun HomeScreenNoInternet(
    modifier: Modifier = Modifier,
    getInformation: (String) -> Unit,
    bin: String
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "No Internet",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
        )
        BasicButton(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.update),
            onClick = { getInformation(bin) }
        )
    }
}

@Preview
@Composable
private fun PreviewHomeScreenNoInternet() {
    CardInformerTheme(dynamicColor = false) {
        HomeScreenNoInternet(getInformation = {}, bin = "")
    }
}