package com.example.cardinformer.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cardinformer.R
import com.example.cardinformer.core.composables.TopBar
import com.example.cardinformer.history.presentation.navigation.HISTORY_ROUTE
import com.example.cardinformer.history.presentation.navigation.historyScreen
import com.example.cardinformer.home.presentation.navigation.HOME_ROUTE
import com.example.cardinformer.home.presentation.navigation.homeScreen

@Composable
fun Navigation() {

    val navController: NavHostController = rememberNavController()

    val items = listOf(
        BottomNavigationItem(
            title = HOME_ROUTE,
            icon = Icons.Filled.Home,
        ),
        BottomNavigationItem(
            title = HISTORY_ROUTE,
            icon = Icons.Filled.Check,
        ),
    )

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier.shadow(4.dp),
                title = stringResource(id = R.string.app_name)
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier.height(96.dp),
                containerColor = MaterialTheme.colorScheme.primary,
            ) {
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.title,
                        onClick = {
                            if (currentRoute != item.title) {
                                navController.navigate(item.title) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.tertiary
                        ),
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = HOME_ROUTE
        ) {
            homeScreen()
            historyScreen()
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
)