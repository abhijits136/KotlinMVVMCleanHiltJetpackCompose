package com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote.dto.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
