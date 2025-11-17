package com.example.kotlinmvvmcleanhiltjetpackcompose.di

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import com.example.kotlinmvvmcleanhiltjetpackcompose.util.CustomAnalyticsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {

    @Binds
    @Singleton
    abstract fun bindAnalyticsService(
        customAnalyticsService: CustomAnalyticsService
    ): AnalyticsService
}
