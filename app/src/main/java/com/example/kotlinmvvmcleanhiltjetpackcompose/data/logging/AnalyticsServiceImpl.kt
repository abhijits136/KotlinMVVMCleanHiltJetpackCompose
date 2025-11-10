package com.example.kotlinmvvmcleanhiltjetpackcompose.data.logging

import android.util.Log
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import javax.inject.Inject

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
    override fun logEvent(name: String, params: Map<String, String>) {
        // In a real app, this would integrate with a real analytics service like Firebase Analytics.
        Log.d("AnalyticsService", "Event: $name, Params: $params")
    }
}
