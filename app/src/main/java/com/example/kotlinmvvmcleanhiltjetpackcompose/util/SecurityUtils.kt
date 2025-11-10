package com.example.kotlinmvvmcleanhiltjetpackcompose.util

import android.util.Log

object SecurityUtils {
    fun maskSensitiveData(data: String): String =
        if (data.length > 4) "****" + data.takeLast(4) else "****"

    fun logSecure(message: String) {
        // Only log in debug builds, never in release
        Log.d("Security", message)
    }
}