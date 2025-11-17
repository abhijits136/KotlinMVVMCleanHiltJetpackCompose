package com.example.kotlinmvvmcleanhiltjetpackcompose.data.mapper

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.remote.dto.Post as PostDto
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.Post as PostDomain

fun PostDto.toDomain(): PostDomain {
    return PostDomain(
        id = id,
        title = title,
        body = body
    )
}
