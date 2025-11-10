package com.example.kotlinmvvmcleanhiltjetpackcompose.data.logging

import android.util.Log

object CrashLogger {
    fun log(throwable: Throwable) {
        // In a real app, this would log to a remote service like Firebase Crashlytics
        Log.e("CrashLogger", "Uncaught exception", throwable)
    }
}
