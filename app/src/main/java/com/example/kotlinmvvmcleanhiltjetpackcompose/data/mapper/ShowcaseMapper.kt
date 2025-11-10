package com.example.kotlinmvvmcleanhiltjetpackcompose.data.mapper

import com.example.kotlinmvvmcleanhiltjetpackcompose.data.model.ShowcaseItemEntity
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.ShowcaseItem

/**
 * Maps a data-layer [ShowcaseItemEntity] to a domain-layer [ShowcaseItem].
 */
fun ShowcaseItemEntity.toDomain(): ShowcaseItem {
    return ShowcaseItem(
        name = this.itemName // Mapping from the data layer's 'itemName' to the domain's 'name'
    )
}
