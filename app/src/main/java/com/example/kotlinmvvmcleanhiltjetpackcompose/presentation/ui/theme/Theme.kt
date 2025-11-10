package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
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

private val LightColorScheme = lightColorScheme(
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

@Composable
fun KotlinMVVMCleanHiltJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
