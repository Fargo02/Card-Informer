package com.example.cardinformer.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cardinformer.home.presentation.HomeRoute

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen() {
    composable(route = HOME_ROUTE) {
        HomeRoute()
    }
}