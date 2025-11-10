package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDialog(state: CustomDialogState, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
        ) {
            Box {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // 1. Icon and Title (Optional)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        state.icon?.let {
                            Icon(painter = painterResource(id = it), contentDescription = "Dialog Icon")
                        }
                        state.title?.let {
                            Text(text = it, textAlign = TextAlign.Center)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // 2. Message (Optional)
                    state.message?.let {
                        Text(text = it, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // 3. Buttons (Optional)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = state.buttonsArrangement
                    ) {
                        state.negativeButton?.let {
                            Button(onClick = it.onClick) {
                                Text(it.text)
                            }
                        }
                        state.neutralButton?.let {
                            Button(onClick = it.onClick) {
                                Text(it.text)
                            }
                        }
                        state.positiveButton?.let {
                            Button(onClick = it.onClick) {
                                Text(it.text)
                            }
                        }
                    }
                }

                // 4. Close Button (Optional)
                if (state.showCloseButton) {
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Close Dialog")
                    }
                }
            }
        }
    }
}
