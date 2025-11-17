package com.example.kotlinmvvmcleanhiltjetpackcompose

import android.content.Context
import android.content.Intent
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.CrashLogger
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.crash.CrashActivity

/**
 * Global uncaught exception handler that logs and shows a friendly dialog.
 */
class GlobalExceptionHandler(
    private val context: Context,
    private val crashLogger: CrashLogger,
    private val defaultHandler: Thread.UncaughtExceptionHandler?
) : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        crashLogger.log(throwable)

        // Launch the crash activity
        val intent = Intent(context, CrashActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        // Terminate the current process
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(10)

        defaultHandler?.uncaughtException(thread, throwable)
    }
}

fun setupGlobalExceptionHandler(context: Context, crashLogger: CrashLogger) {
    val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
    Thread.setDefaultUncaughtExceptionHandler(GlobalExceptionHandler(context, crashLogger, defaultHandler))
}
