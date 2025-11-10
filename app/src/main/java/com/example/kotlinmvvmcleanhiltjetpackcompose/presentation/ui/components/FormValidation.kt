package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

object FormValidation {
    fun isEmailValid(email: String): Boolean =
        email.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))

    fun isPasswordValid(password: String): Boolean =
        password.length >= 8

    fun isNotEmpty(value: String): Boolean =
        value.isNotBlank()
}
