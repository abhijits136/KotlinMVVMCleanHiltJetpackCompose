package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) {
        darkColorScheme(
            primary = BrandDarkColors.primary,
            secondary = BrandDarkColors.secondary,
            background = BrandDarkColors.background,
            surface = BrandDarkColors.surface,
            error = BrandDarkColors.error,
            onPrimary = BrandDarkColors.onPrimary,
            onSecondary = BrandDarkColors.onSecondary,
            onBackground = BrandDarkColors.onBackground,
            onSurface = BrandDarkColors.onSurface,
            onError = BrandDarkColors.onError
        )
    } else {
        lightColorScheme(
            primary = BrandColors.primary,
            secondary = BrandColors.secondary,
            background = BrandColors.background,
            surface = BrandColors.surface,
            error = BrandColors.error,
            onPrimary = BrandColors.onPrimary,
            onSecondary = BrandColors.onSecondary,
            onBackground = BrandColors.onBackground,
            onSurface = BrandColors.onSurface,
            onError = BrandColors.onError
        )
    }
    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography,
        content = content
    )
}
