package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DialogHost() {
    val currentDialog = DialogManager.currentDialog.value

    if (currentDialog != null) {
        when (currentDialog) {
            is DialogCommand.Custom -> {
                CustomDialog(
                    state = currentDialog.state,
                    onDismiss = { DialogManager.hide() }
                )
            }
            is DialogCommand.Error -> {
                ErrorDialog(
                    error = currentDialog.error,
                    onDismiss = { DialogManager.hide() }
                )
            }
            is DialogCommand.Info -> {
                // This is the legacy dialog. It can be removed once all calls are updated.
                AlertDialog(
                    onDismissRequest = { DialogManager.hide() },
                    title = { Text(text = currentDialog.title) },
                    text = { Text(text = currentDialog.message) },
                    confirmButton = {
                        Button(onClick = { DialogManager.hide() }) {
                            Text("OK")
                        }
                    }
                )
            }
            // Add the missing branches below. You will need to implement
            // the corresponding Composable functions for these dialogs.
            is DialogCommand.Confirm -> {
                // TODO: Implement ConfirmDialog
            }
            is DialogCommand.Destructive -> {
                // TODO: Implement DestructiveDialog
            }
            is DialogCommand.Upgrade -> {
                // TODO: Implement UpgradeDialog
            }
        }
    }
}
