package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.showcase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.AnalyticsService
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.ConfigService
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.repository.SecureStorage
import com.example.kotlinmvvmcleanhiltjetpackcompose.domain.use_case.GetShowcaseItemsUseCase
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.AppPermissionStatus
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ShowcaseUiState(
    val loadingState: LoadingState = LoadingState.Idle,
    val showDialog: Boolean = false,
    val permissionStatus: AppPermissionStatus = AppPermissionStatus.NotDetermined,
    val textFieldValue: String = "",
    val listItems: List<String> = emptyList(),
    val showSplash: Boolean = true,
    val secretValue: String = "",
    val analyticsEventFired: Boolean = false,
    val featureFlagEnabled: Boolean = false,
    val accessibilityChecked: Boolean = false,
    val cameraPermissionStatus: AppPermissionStatus = AppPermissionStatus.NotDetermined,
    val locationPermissionStatus: AppPermissionStatus = AppPermissionStatus.NotDetermined
)

@HiltViewModel
class ShowcaseViewModel @Inject constructor(
    private val getShowcaseItemsUseCase: GetShowcaseItemsUseCase,
    private val analyticsService: AnalyticsService,
    private val configService: ConfigService,
    private val secureStorage: SecureStorage
) : ViewModel() {

    private val _uiState = MutableStateFlow(ShowcaseUiState())
    val uiState: StateFlow<ShowcaseUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val items = getShowcaseItemsUseCase().map { it.name }
            _uiState.update { it.copy(listItems = items) }
        }
    }

    fun onShowLoadingClicked() {
        _uiState.update { it.copy(loadingState = LoadingState.Loading) }
    }

    fun onHideLoadingClicked() {
        _uiState.update { it.copy(loadingState = LoadingState.Idle) }
    }

    fun onShowDialogClicked() {
        _uiState.update { it.copy(showDialog = true) }
    }

    fun onDialogDismissed() {
        _uiState.update { it.copy(showDialog = false) }
    }

    fun onPermissionResult(isGranted: Boolean) {
        val status = if (isGranted) AppPermissionStatus.Granted else AppPermissionStatus.Denied
        _uiState.update { it.copy(permissionStatus = status) }
    }

    fun onTextFieldValueChanged(newValue: String) {
        _uiState.update { it.copy(textFieldValue = newValue) }
    }

    fun onSplashScreenFinished() {
        _uiState.update { it.copy(showSplash = false) }
    }

    fun onSaveSecretClicked() {
        secureStorage.putSecret("key", "secretValue1234")
    }

    fun onReadSecretClicked() {
        val secret = secureStorage.getSecret("key") ?: "(none)"
        _uiState.update { it.copy(secretValue = secret) }
    }

    fun onLogAnalyticsEventClicked() {
        analyticsService.logEvent("button_clicked", mapOf("button_name" to "log_analytics"))
        _uiState.update { it.copy(analyticsEventFired = true) }
    }

    fun onCheckFeatureFlagClicked() {
        val isEnabled = configService.getFeatureFlag("new_ui")
        _uiState.update { it.copy(featureFlagEnabled = isEnabled) }
    }

    fun onAccessibilityClicked() {
        _uiState.update { it.copy(accessibilityChecked = true) }
    }

    fun onPermissionsResult(permissions: Map<String, Boolean>) {
        val cameraStatus = if (permissions[android.Manifest.permission.CAMERA] == true) AppPermissionStatus.Granted else AppPermissionStatus.Denied
        val locationStatus = if (permissions[android.Manifest.permission.ACCESS_FINE_LOCATION] == true) AppPermissionStatus.Granted else AppPermissionStatus.Denied
        _uiState.update {
            it.copy(
                cameraPermissionStatus = cameraStatus,
                locationPermissionStatus = locationStatus
            )
        }
    }
}
