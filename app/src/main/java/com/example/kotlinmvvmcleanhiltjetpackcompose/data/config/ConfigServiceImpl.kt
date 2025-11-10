package com.example.kotlinmvvmcleanhiltjetpackcompose.data.config

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ConfigService
import javax.inject.Inject

class ConfigServiceImpl @Inject constructor() : ConfigService {
    // In a real app, this would fetch flags from a remote config service like Firebase Remote Config.
    private val featureFlags = mapOf(
        "new_ui" to true,
        "experimental_feature" to false
    )

    override fun getFeatureFlag(name: String): Boolean {
        return featureFlags[name] ?: false
    }
}
