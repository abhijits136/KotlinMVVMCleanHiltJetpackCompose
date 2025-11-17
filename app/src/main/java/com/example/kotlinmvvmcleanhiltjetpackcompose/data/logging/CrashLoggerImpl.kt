package com.example.kotlinmvvmcleanhiltjetpackcompose.data.logging

import android.util.Log
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.CrashLogger
import timber.log.Timber
import javax.inject.Inject

class CrashLoggerImpl @Inject constructor() : CrashLogger {
    override fun log(throwable: Throwable) {
        // In a real app, this would log to a remote service like Firebase Crashlytics
        Timber.e(throwable)
    }
}
