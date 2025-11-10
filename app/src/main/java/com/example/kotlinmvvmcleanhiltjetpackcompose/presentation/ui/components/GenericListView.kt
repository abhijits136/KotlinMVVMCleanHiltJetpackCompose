package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable

@Composable
fun <T> GenericListView(
    items: List<T>,
    isLoading: Boolean,
    isPaginating: Boolean,
    onLoadMore: () -> Unit,
    itemContent: @Composable (T, Int) -> Unit,
    animation: @Composable (content: @Composable () -> Unit) -> Unit
) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            itemContent(item, index)
        }

        if (isLoading || isPaginating) {
            item {
                LoadingIndicator()
            }
        }

        if (!isLoading && items.isNotEmpty()) {
            item {
                onLoadMore()
            }
        }
    }
}
