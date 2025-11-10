package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.use_case

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.ShowcaseItem
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ShowcaseRepository
import javax.inject.Inject

class GetShowcaseItemsUseCase @Inject constructor(
    private val repository: ShowcaseRepository
) {
    suspend operator fun invoke(): List<ShowcaseItem> {
        return repository.getShowcaseItems()
    }
}
