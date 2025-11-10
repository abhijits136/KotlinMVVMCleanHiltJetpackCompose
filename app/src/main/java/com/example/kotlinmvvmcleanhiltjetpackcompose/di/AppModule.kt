package com.example.kotlinmvvmcleanhiltjetpackcompose.di

// ========= IMPLEMENTATIONS =========
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.config.ConfigServiceImpl
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.logging.AnalyticsServiceImpl
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.repository.ShowcaseRepositoryImpl
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.storage.SecureStorageImpl

// ========= INTERFACES (ABSTRACTIONS) - THIS IS THE CRITICAL PART =========
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ConfigService
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.SecureStorage
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ShowcaseRepository

// ========= DAGGER & HILT =========
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// This module provides the concrete implementations for the interfaces used in the application.
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindShowcaseRepository(
        showcaseRepositoryImpl: ShowcaseRepositoryImpl
    ): ShowcaseRepository

    @Binds
    @Singleton
    abstract fun bindAnalyticsService(
        analyticsServiceImpl: AnalyticsServiceImpl
    ): AnalyticsService

    @Binds
    @Singleton
    abstract fun bindConfigService(
        configServiceImpl: ConfigServiceImpl
    ): ConfigService

    @Binds
    @Singleton
    abstract fun bindSecureStorage(
        secureStorageImpl: SecureStorageImpl
    ): SecureStorage
}
