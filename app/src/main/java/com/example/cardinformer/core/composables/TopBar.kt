package com.example.cardinformer.core.composables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    titleContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    title: String = ""
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        expandedHeight = 50.dp,
        title = { Text(title) },
        navigationIcon = {},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            titleContentColor = titleContentColor,
            containerColor = containerColor
        )
    )
}