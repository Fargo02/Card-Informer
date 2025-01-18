package com.example.cardinformer.history.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cardinformer.history.presentation.HistoryRoute
import com.example.cardinformer.history.presentation.HistoryScreen

const val HISTORY_ROUTE = "history"

fun NavGraphBuilder.historyScreen() {
    composable(route = HISTORY_ROUTE) {
        HistoryRoute()
    }
}