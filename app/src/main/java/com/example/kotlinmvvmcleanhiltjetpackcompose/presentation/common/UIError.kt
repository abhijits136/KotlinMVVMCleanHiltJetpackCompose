package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common

/**
 * Represents a user-facing error for UI display.
 */
data class UIError(
    val code: String,
    val title: String,
    val message: String,
    val retryAction: (() -> Unit)? = null,
    val severity: Severity = Severity.Error
) {
    enum class Severity { Info, Warning, Error, Critical }
}
