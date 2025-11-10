package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.ShowcaseItem

interface ShowcaseRepository {
    suspend fun getShowcaseItems(): List<ShowcaseItem>
}
