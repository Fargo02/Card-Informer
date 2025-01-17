package com.example.cardinformer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cardinformer.history.presentation.navigation.historyScreen
import com.example.cardinformer.history.presentation.navigation.navigationToHistory
import com.example.cardinformer.home.presentation.navigation.HOME_ROUTE
import com.example.cardinformer.home.presentation.navigation.homeScreen
import com.example.cardinformer.home.presentation.navigation.navigateToHome

@Composable
fun Navigation() {

    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME_ROUTE) {

        homeScreen(navToHistory = {navController.navigationToHistory()})

        historyScreen(navToHome = {navController.navigateToHome()})
    }
}