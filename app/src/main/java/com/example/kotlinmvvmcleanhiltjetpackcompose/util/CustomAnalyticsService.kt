package com.example.kotlinmvvmcleanhiltjetpackcompose.util

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import timber.log.Timber
import javax.inject.Inject

class CustomAnalyticsService @Inject constructor() : AnalyticsService {
    override fun logEvent(name: String, params: Map<String, String>) {
        Timber.d("Logged event: $name, params: $params")
    }
}
