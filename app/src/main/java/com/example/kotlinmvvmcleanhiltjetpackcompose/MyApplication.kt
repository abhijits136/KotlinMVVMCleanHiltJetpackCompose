package com.example.kotlinmvvmcleanhiltjetpackcompose

import android.app.Application
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.CrashLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var crashLogger: CrashLogger

    override fun onCreate() {
        super.onCreate()
        setupGlobalExceptionHandler(this, crashLogger)
    }
}
