package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository

interface SecureStorage {
    fun putSecret(key: String, value: String)
    fun getSecret(key: String): String?
}
