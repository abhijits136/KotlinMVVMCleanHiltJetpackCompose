package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.showcase

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlinmvvmcleanhiltjetpackcompose.R
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.AppPermissionStatus
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.ErrorHandler
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.LoadingState
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components.*
import com.example.kotlinmvvmcleanhiltjetpackcompose.util.SecurityUtils
import kotlinx.coroutines.delay

@Composable
fun ShowcaseScreen(viewModel: ShowcaseViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    val multiplePermissionsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = viewModel::onPermissionsResult
    )

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item { Text(stringResource(id = R.string.showcase_title), style = MaterialTheme.typography.headlineSmall) }

            item {
                Text(stringResource(id = R.string.loading_indicator_title))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = viewModel::onShowLoadingClicked) { Text(stringResource(id = R.string.show_loading_button)) }
                    Button(onClick = viewModel::onHideLoadingClicked) { Text(stringResource(id = R.string.hide_loading_button)) }
                }
            }

            item {
                Text(stringResource(id = R.string.error_handling_title))
                val sampleErrorMessage = stringResource(id = R.string.sample_error_message)
                Button(onClick = {
                    val error = ErrorHandler.map(Exception(sampleErrorMessage)) {
                        // Optional retry action
                        DialogManager.hide()
                    }
                    DialogManager.show(DialogCommand.Error(error))
                }) { Text(stringResource(id = R.string.show_error_button)) }
            }

            item {
                Text(stringResource(id = R.string.dialog_manager_title))
                val dialogTitle = stringResource(id = R.string.info_dialog_title)
                val dialogMessage = stringResource(id = R.string.info_dialog_message)
                val positiveButtonText = stringResource(id = R.string.dialog_button_positive)
                val negativeButtonText = stringResource(id = R.string.dialog_button_negative)
                val neutralButtonText = stringResource(id = R.string.dialog_button_neutral)

                Button(onClick = {
                    val dialogState = CustomDialogState(
                        icon = R.drawable.ic_launcher_foreground, // Example icon
                        title = dialogTitle,
                        message = dialogMessage,
                        positiveButton = DialogButton(positiveButtonText) {
                            // Handle positive button click
                            DialogManager.hide()
                        },
                        negativeButton = DialogButton(negativeButtonText) {
                            // Handle negative button click
                            DialogManager.hide()
                        },
                        neutralButton = DialogButton(neutralButtonText) {
                            // Handle neutral button click
                            DialogManager.hide()
                        },
                        showCloseButton = false, // Demonstrate hiding the close button
                        buttonsArrangement = Arrangement.End // Demonstrate changing button alignment
                    )
                    DialogManager.show(DialogCommand.Custom(dialogState))
                    viewModel.onShowDialogClicked()
                }) { Text(stringResource(id = R.string.show_dialog_button)) }
            }

            item {
                Text(stringResource(id = R.string.permission_manager_title))
                Column {
                    Text(stringResource(id = R.string.camera_permission_status, uiState.cameraPermissionStatus))
                    Text(stringResource(id = R.string.location_permission_status, uiState.locationPermissionStatus))
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        multiplePermissionsLauncher.launch(
                            arrayOf(
                                Manifest.permission.CAMERA,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            )
                        )
                    }) {
                        Text(stringResource(id = R.string.request_permissions_button))
                    }
                }
            }

            item { Text(stringResource(id = R.string.generic_list_view_title)) }
            items(uiState.listItems) { item ->
                Text(item)
            }

            item {
                Text(stringResource(id = R.string.buttons_and_text_fields_title))
                PrimaryTextField(
                    value = uiState.textFieldValue,
                    onValueChange = viewModel::onTextFieldValueChanged,
                    label = stringResource(id = R.string.enter_text_label)
                )
                PrimaryButton(
                    text = stringResource(id = R.string.submit_button),
                    onClick = {},
                    enabled = uiState.textFieldValue.isNotBlank(),
                    loading = false
                )
            }

            item {
                Text(stringResource(id = R.string.secure_storage_title))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = viewModel::onSaveSecretClicked) { Text(stringResource(id = R.string.save_secret_button)) }
                    Button(onClick = viewModel::onReadSecretClicked) { Text(stringResource(id = R.string.read_secret_button)) }
                }
                if (uiState.secretValue.isNotBlank()) Text(stringResource(id = R.string.secret_prefix, SecurityUtils.maskSensitiveData(uiState.secretValue)))
            }

            item {
                Text(stringResource(id = R.string.analytics_example_title))
                Button(onClick = viewModel::onLogAnalyticsEventClicked) { Text(stringResource(id = R.string.log_analytics_event_button)) }
                if (uiState.analyticsEventFired) Text(stringResource(id = R.string.analytics_event_fired_message))
            }

            item {
                Text(stringResource(id = R.string.config_feature_flag_title))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = viewModel::onCheckFeatureFlagClicked) { Text(stringResource(id = R.string.check_new_ui_flag_button)) }
                }
                Text(stringResource(id = R.string.new_ui_flag_status, uiState.featureFlagEnabled))
            }

            item {
                Text(stringResource(id = R.string.accessibility_example_title))
                PrimaryButton(
                    text = stringResource(id = R.string.accessible_button),
                    onClick = viewModel::onAccessibilityClicked,
                    contentDescription = stringResource(id = R.string.accessible_button_content_description)
                )
                if (uiState.accessibilityChecked) Text(stringResource(id = R.string.button_clicked_message))
            }
        }

        if (uiState.showDialog) DialogHost()
        if (uiState.loadingState == LoadingState.Loading) LoadingIndicator()
        if (uiState.permissionStatus == AppPermissionStatus.Denied) PermissionDialog(
            title = stringResource(id = R.string.permission_required_title),
            message = stringResource(id = R.string.permission_required_message),
            onGrant = { viewModel.onPermissionResult(true) },
            onDeny = { viewModel.onPermissionResult(false) },
            onSettings = { /* Open settings */ }
        )
        if (uiState.showSplash) SplashScreen(
            onInitComplete = {
                viewModel.onSplashScreenFinished()
                multiplePermissionsLauncher.launch(
                    arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                )
            },
            showProgress = true,
            brandingRes = R.drawable.ic_launcher_foreground,
            initTasks = { delay(1000) }
        )
    }
}
