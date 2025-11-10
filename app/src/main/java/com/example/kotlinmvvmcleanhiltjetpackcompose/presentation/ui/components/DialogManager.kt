package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.mutableStateOf
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.UIError

/**
 * Defines the data needed for a single button in the custom dialog.
 */
data class DialogButton(
    val text: String,
    val onClick: () -> Unit,
)

/**
 * Defines the complete state for rendering a custom dialog.
 * All properties are optional to allow for maximum flexibility.
 */
data class CustomDialogState(
    @DrawableRes val icon: Int? = null,
    val title: String? = null,
    val message: String? = null,
    val positiveButton: DialogButton? = null,
    val negativeButton: DialogButton? = null,
    val neutralButton: DialogButton? = null,
    val showCloseButton: Boolean = true,
    val buttonsArrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly
)

/**
 * Represents the command to show a dialog. This can be extended to support different
 * types of dialogs in the future (e.g., loading, bottom sheet).
 */
sealed class DialogCommand {
    data class Custom(val state: CustomDialogState) : DialogCommand()
    data class Error(val error: UIError) : DialogCommand()
    // Legacy Info dialog, can be deprecated later
    data class Info(val title: String, val message: String) : DialogCommand()
    data class Confirm(val title: String, val message: String) : DialogCommand()

    data class Destructive(val title: String, val message: String) : DialogCommand()
    data class Upgrade(val title: String, val message: String) : DialogCommand()
}

/**
 * A singleton object to manage the presentation of dialogs throughout the application.
 */
object DialogManager {
    val currentDialog = mutableStateOf<DialogCommand?>(null)

    fun show(command: DialogCommand) {
        currentDialog.value = command
    }

    fun hide() {
        currentDialog.value = null
    }
}
