package com.example.cardinformer.history.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cardinformer.history.presentation.HistoryScreen

const val HISTORY_SCREEN = "history"

fun NavGraphBuilder.historyScreen(
    navToHome: () -> Unit
) {
    composable(route = HISTORY_SCREEN) {
        HistoryScreen(navToHome = navToHome)
    }
}

fun NavController.navigationToHistory() = navigate(HISTORY_SCREEN) {
    navigate(
        route = HISTORY_SCREEN,
    ) {
        launchSingleTop = true
    }
}