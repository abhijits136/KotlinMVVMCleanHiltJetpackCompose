package com.example.kotlinmvvmcleanhiltjetpackcompose

import android.app.Application
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.logging.CrashLogger

/**
 * Global uncaught exception handler that logs and shows a friendly dialog.
 */
class GlobalExceptionHandler(
    private val defaultHandler: Thread.UncaughtExceptionHandler?
) : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        CrashLogger.log(throwable)
        // TODO: Show friendly dialog or notification to user
        defaultHandler?.uncaughtException(thread, throwable)
    }
}

fun Application.setupGlobalExceptionHandler() {
    val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
    Thread.setDefaultUncaughtExceptionHandler(GlobalExceptionHandler(defaultHandler))
}
