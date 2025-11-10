package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common

sealed class AppPermissionStatus {
    object Granted : AppPermissionStatus()
    object Denied : AppPermissionStatus()
    object PermanentlyDenied : AppPermissionStatus()
    object NotDetermined : AppPermissionStatus()
}
