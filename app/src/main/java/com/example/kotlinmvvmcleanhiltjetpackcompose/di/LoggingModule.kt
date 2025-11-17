package com.example.kotlinmvvmcleanhiltjetpackcompose.di

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.logging.CrashLoggerImpl
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.CrashLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggingModule {

    @Binds
    @Singleton
    abstract fun bindCrashLogger(crashLoggerImpl: CrashLoggerImpl): CrashLogger
}
