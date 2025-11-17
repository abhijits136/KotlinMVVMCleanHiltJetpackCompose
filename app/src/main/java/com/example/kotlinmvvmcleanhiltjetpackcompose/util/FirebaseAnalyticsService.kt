package com.example.kotlinmvvmcleanhiltjetpackcompose.util

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import javax.inject.Inject

class FirebaseAnalyticsService @Inject constructor() : AnalyticsService {
    override fun logEvent(name: String, params: Map<String, String>) {
        // TODO: Add Firebase Analytics logging here
    }
}
