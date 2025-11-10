package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.navigation.BottomNavBar
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.navigation.Screen
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components.CommonAppBar
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.showcase.ShowcaseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val screens = listOf(
        Screen.Home,
        Screen.Favorites,
        Screen.Profile,
        Screen.Settings
    )

    Scaffold(
        topBar = { CommonAppBar(title = stringResource(id = Screen.Home.resourceId), canNavigateBack = false, onNavigateUp = {}) },
        bottomBar = { BottomNavBar(navController = navController, items = screens) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) { ShowcaseScreen() }
                composable(Screen.Favorites.route) { Text("Favorites Screen") }
                composable(Screen.Profile.route) { Text("Profile Screen") }
                composable(Screen.Settings.route) { Text("Settings Screen") }
            }
        }
    }
}
