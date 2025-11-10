package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository

interface ConfigService {
    fun getFeatureFlag(name: String): Boolean
}
