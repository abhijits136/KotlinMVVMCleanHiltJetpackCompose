package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Spacing {
    val xs = 4.dp
    val sm = 8.dp
    val md = 16.dp
    val lg = 24.dp
    val xl = 32.dp
}

object Typography {
    val h1 = 30.sp
    val h2 = 24.sp
    val body = 16.sp
    val caption = 12.sp
    val bold = FontWeight.Bold
    val normal = FontWeight.Normal
}

object BrandColors {
    val primary = Color(0xFF6200EE)
    val primaryVariant = Color(0xFF3700B3)
    val secondary = Color(0xFF03DAC6)
    val background = Color(0xFFFFFFFF)
    val surface = Color(0xFFFFFFFF)
    val error = Color(0xFFB00020)
    val onPrimary = Color.White
    val onSecondary = Color.Black
    val onBackground = Color.Black
    val onSurface = Color.Black
    val onError = Color.White
}

object BrandDarkColors {
    val primary = Color(0xFFBB86FC)
    val primaryVariant = Color(0xFF3700B3)
    val secondary = Color(0xFF03DAC6)
    val background = Color(0xFF121212)
    val surface = Color(0xFF121212)
    val error = Color(0xFFCF6679)
    val onPrimary = Color.Black
    val onSecondary = Color.Black
    val onBackground = Color.White
    val onSurface = Color.White
    val onError = Color.Black
}
