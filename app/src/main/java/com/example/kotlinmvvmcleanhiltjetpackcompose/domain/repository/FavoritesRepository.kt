package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote.NetworkResult
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.Post

interface FavoritesRepository {
    suspend fun getPosts(): NetworkResult<List<Post>>
}
