package com.example.cardinformer.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cardinformer.home.presentation.HomeScreen

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(
    navToHistory: () -> Unit
) {
    composable(route = HOME_ROUTE) {
        HomeScreen(navToHistory = navToHistory)
    }
}

fun NavController.navigateToHome() = navigate(HOME_ROUTE) {
    popUpTo(HOME_ROUTE) {
        inclusive = true
    }
}