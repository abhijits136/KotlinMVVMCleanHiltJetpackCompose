package com.example.kotlinmvvmcleanhiltjetpackcompose.domain.use_case

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.ShowcaseItem
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ShowcaseRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetShowcaseItemsUseCaseTest {

    private lateinit var getShowcaseItemsUseCase: GetShowcaseItemsUseCase
    private val mockShowcaseRepository: ShowcaseRepository = mock()

    @Before
    fun setUp() {
        getShowcaseItemsUseCase = GetShowcaseItemsUseCase(mockShowcaseRepository)
    }

    @Test
    fun `invoke() returns list of showcase items from repository`() = runTest {
        // Given
        val expectedItems = listOf(
            ShowcaseItem(name = "Loading Indicator"),
            ShowcaseItem(name = "Error Handling")
        )
        // Mock the suspend function to return a List directly
        whenever(mockShowcaseRepository.getShowcaseItems()).doReturn(expectedItems)

        // When
        val result = getShowcaseItemsUseCase()

        // Then
        assertThat(result).isEqualTo(expectedItems)
    }

    @Test
    fun `invoke() returns empty list when repository is empty`() = runTest {
        // Given
        // Mock the suspend function to return an empty List
        whenever(mockShowcaseRepository.getShowcaseItems()).doReturn(emptyList())

        // When
        val result = getShowcaseItemsUseCase()

        // Then
        assertThat(result).isEmpty()
    }
}
