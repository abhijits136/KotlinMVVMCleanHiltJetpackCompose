package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.showcase

import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.model.ShowcaseItem
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ConfigService
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.SecureStorage
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.use_case.GetShowcaseItemsUseCase
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.LoadingState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class ShowcaseViewModelTest {

    // Dependencies to be mocked
    private val getShowcaseItemsUseCase: GetShowcaseItemsUseCase = mock()
    private val analyticsService: AnalyticsService = mock()
    private val configService: ConfigService = mock()
    private val secureStorage: SecureStorage = mock()

    private lateinit var viewModel: ShowcaseViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun createViewModel() {
        viewModel = ShowcaseViewModel(
            getShowcaseItemsUseCase = getShowcaseItemsUseCase,
            analyticsService = analyticsService,
            configService = configService,
            secureStorage = secureStorage
        )
    }

    @Test
    fun `init loads showcase items and updates state`() = runTest {
        // Given
        val items = listOf(ShowcaseItem("Test Item"))
        whenever(getShowcaseItemsUseCase()).doReturn(items)

        // When
        createViewModel()
        
        // Then
        testDispatcher.scheduler.advanceUntilIdle()
        val expectedState = ShowcaseUiState(listItems = listOf("Test Item"))
        assertThat(viewModel.uiState.value.listItems).isEqualTo(expectedState.listItems)
    }

    @Test
    fun `onShowLoadingClicked() sets loading state to Loading`() = runTest {
        // Given
        whenever(getShowcaseItemsUseCase()).doReturn(emptyList())
        createViewModel()
        
        // When
        viewModel.onShowLoadingClicked()

        // Then
        assertThat(viewModel.uiState.value.loadingState).isEqualTo(LoadingState.Loading)
    }

    @Test
    fun `onLogAnalyticsEventClicked() logs event and updates state`() = runTest {
        // Given
        whenever(getShowcaseItemsUseCase()).doReturn(emptyList())
        createViewModel()

        // When
        viewModel.onLogAnalyticsEventClicked()

        // Then
        verify(analyticsService).logEvent("button_clicked", mapOf("button_name" to "log_analytics"))
        assertThat(viewModel.uiState.value.analyticsEventFired).isTrue()
    }

    @Test
    fun `onCheckFeatureFlagClicked() checks flag and updates state`() = runTest {
        // Given
        val flagName = "new_ui"
        whenever(configService.getFeatureFlag(flagName)).doReturn(true)
        whenever(getShowcaseItemsUseCase()).doReturn(emptyList())
        createViewModel()

        // When
        viewModel.onCheckFeatureFlagClicked()

        // Then
        verify(configService).getFeatureFlag(flagName)
        assertThat(viewModel.uiState.value.featureFlagEnabled).isTrue()
    }

    @Test
    fun `onSaveSecretClicked() saves secret via secure storage`() = runTest {
        // Given
        whenever(getShowcaseItemsUseCase()).doReturn(emptyList())
        createViewModel()

        // When
        viewModel.onSaveSecretClicked()

        // Then
        verify(secureStorage).putSecret("key", "secretValue1234")
    }

    @Test
    fun `onReadSecretClicked() reads secret and updates state`() = runTest {
        // Given
        val secret = "my_secret"
        whenever(secureStorage.getSecret("key")).doReturn(secret)
        whenever(getShowcaseItemsUseCase()).doReturn(emptyList())
        createViewModel()

        // When
        viewModel.onReadSecretClicked()

        // Then
        verify(secureStorage).getSecret("key")
        assertThat(viewModel.uiState.value.secretValue).isEqualTo(secret)
    }
}
