package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.UIError

/**
 * Generic error view for displaying user-facing errors.
 */
@Composable
fun ErrorView(
    error: UIError,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = error.title)
        Text(text = error.message)
        error.retryAction?.let { retry ->
            Button(onClick = retry) {
                Text("Retry")
            }
        }
    }
}
