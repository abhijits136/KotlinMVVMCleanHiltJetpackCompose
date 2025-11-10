package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kotlinmvvmcleanhiltjetpackcompose.R

/**
 * Represents the screens in the app that are part of the bottom navigation.
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.screen_home, Icons.Default.Home)
    object Favorites : Screen("favorites", R.string.screen_favorites, Icons.Default.Favorite)
    object Profile : Screen("profile", R.string.screen_profile, Icons.Default.Person)
    object Settings : Screen("settings", R.string.screen_settings, Icons.Default.Settings)
}
