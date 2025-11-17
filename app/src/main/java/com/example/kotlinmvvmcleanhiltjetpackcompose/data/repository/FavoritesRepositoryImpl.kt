package com.example.kotlinmvvmcleanhiltjetpackcompose.data.repository

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.mapper.toDomain
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote.ApiService
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote.NetworkResult
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.Post
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.FavoritesRepository
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : FavoritesRepository {

    override suspend fun getPosts(): NetworkResult<List<Post>> {
        return try {
            val posts = apiService.getPosts().map { it.toDomain() }
            NetworkResult.Success(posts)
        } catch (e: Exception) {
            NetworkResult.Error("Could not fetch posts. Please check your internet connection.")
        }
    }
}
