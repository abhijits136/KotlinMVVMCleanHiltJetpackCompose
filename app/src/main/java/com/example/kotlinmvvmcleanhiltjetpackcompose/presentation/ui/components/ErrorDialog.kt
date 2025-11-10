package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.UIError

/**
 * Generic error dialog for displaying user-facing errors.
 */
@Composable
fun ErrorDialog(
    error: UIError,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = error.title) },
        text = { Text(text = error.message) },
        confirmButton = {
            error.retryAction?.let { retry ->
                Button(onClick = {
                    retry()
                    onDismiss()
                }) {
                    Text("Retry")
                }
            } ?: Button(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}
