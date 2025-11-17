package com.example.kotlinmvvmcleanhiltjetpackcompose.util

import android.util.Log
import timber.log.Timber

object SecurityUtils {
    fun maskSensitiveData(data: String): String =
        if (data.length > 4) "****" + data.takeLast(4) else "****"

    fun logSecure(message: String) {
        // Only log in debug builds, never in release
        Timber.d(message = "Security : $message")
    }
}