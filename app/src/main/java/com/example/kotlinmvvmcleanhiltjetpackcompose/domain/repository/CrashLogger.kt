package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository

interface CrashLogger {
    fun log(throwable: Throwable)
}
