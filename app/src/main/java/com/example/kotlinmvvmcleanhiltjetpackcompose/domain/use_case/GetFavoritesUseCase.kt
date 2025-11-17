package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.use_case

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote.NetworkResult
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.Post
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.FavoritesRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(): NetworkResult<List<Post>> {
        return repository.getPosts()
    }
}
