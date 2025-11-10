package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository

/**
 * An abstraction for an analytics service. This interface allows for fake or mock implementations
 * in tests, and a real implementation in the production app.
 */
interface AnalyticsService {
    fun logEvent(name: String, params: Map<String, String>)
}
