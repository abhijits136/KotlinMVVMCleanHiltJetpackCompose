package com.example.kotlinmvvmcleanhiltjetpackcompose.data.repository

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.mapper.toDomain
import com.example.kotlinmvvmcleanhiltjetpackcompose.data.model.ShowcaseItemEntity
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.ShowcaseItem
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ShowcaseRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class ShowcaseRepositoryImpl @Inject constructor() : ShowcaseRepository {
    override suspend fun getShowcaseItems(): List<ShowcaseItem> {
        // Simulate a network or database call
        delay(1500)

        // In a real app, this list would come from a data source (e.g., Retrofit or Room)
        val rawData = listOf(
            ShowcaseItemEntity(itemName = "Loading Indicator"),
            ShowcaseItemEntity(itemName = "Error Handling"),
            ShowcaseItemEntity(itemName = "Dialog Manager"),
            ShowcaseItemEntity(itemName = "Permission Manager"),
            ShowcaseItemEntity(itemName = "Generic List View"),
            ShowcaseItemEntity(itemName = "Buttons and Text Fields"),
            ShowcaseItemEntity(itemName = "Secure Storage"),
            ShowcaseItemEntity(itemName = "Analytics Example"),
            ShowcaseItemEntity(itemName = "Config/Feature Flag"),
            ShowcaseItemEntity(itemName = "Accessibility Example")
        )

        // Map the data-layer entities to domain-layer models before returning
        return rawData.map { it.toDomain() }
    }
}
