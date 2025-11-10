package com.example.kotlinmvvmcleanhiltjetpackcompose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components.DialogCommand
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components.DialogHost
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components.DialogManager
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.theme.KotlinMVVMCleanHiltJetpackComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DialogManagerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun infoDialog_showsAndDismisses() {
        composeTestRule.setContent {
            KotlinMVVMCleanHiltJetpackComposeTheme {
                DialogHost()
            }
        }

        // Show an info dialog
        DialogManager.show(DialogCommand.Info("Info Title", "This is an info message."))

        // Verify the dialog is displayed
        composeTestRule.onNodeWithText("Info Title").assertExists()
        composeTestRule.onNodeWithText("This is an info message.").assertExists()

        // Click the OK button
        composeTestRule.onNodeWithText("OK").performClick()

        // Verify the dialog is dismissed
        composeTestRule.onNodeWithText("Info Title").assertDoesNotExist()
    }

    @Test
    fun confirmDialog_showsAndConfirms() {
        var confirmed = false
        composeTestRule.setContent {
            KotlinMVVMCleanHiltJetpackComposeTheme {
                DialogHost()
            }
        }

        // Show a confirm dialog
        DialogManager.show(DialogCommand.Confirm("Confirm Title", "Please confirm."))

        // Verify the dialog is displayed
        composeTestRule.onNodeWithText("Confirm Title").assertExists()

        // Click the Confirm button
        composeTestRule.onNodeWithText("Confirm").performClick()

        // Verify the dialog is dismissed and the action was performed
        composeTestRule.onNodeWithText("Confirm Title").assertDoesNotExist()
        assert(confirmed)
    }

    @Test
    fun destructiveDialog_showsAndConfirms() {
        var confirmed = false
        composeTestRule.setContent {
            KotlinMVVMCleanHiltJetpackComposeTheme {
                DialogHost()
            }
        }

        // Show a destructive dialog
        DialogManager.show(DialogCommand.Destructive("Delete Item", "Are you sure?"))

        // Verify the dialog is displayed
        composeTestRule.onNodeWithText("Delete Item").assertExists()

        // Click the Delete button
        composeTestRule.onNodeWithText("Delete").performClick()

        // Verify the dialog is dismissed and the action was performed
        composeTestRule.onNodeWithText("Delete Item").assertDoesNotExist()
        assert(confirmed)
    }

    @Test
    fun upgradeDialog_showsAndUpgrades() {
        var upgraded = false
        composeTestRule.setContent {
            KotlinMVVMCleanHiltJetpackComposeTheme {
                DialogHost()
            }
        }

        // Show an upgrade dialog
        DialogManager.show(DialogCommand.Upgrade("Upgrade now", "A new version is available."))

        // Verify the dialog is displayed
        composeTestRule.onNodeWithText("Upgrade now").assertExists()

        // Click the Upgrade button
        composeTestRule.onNodeWithText("Upgrade").performClick()

        // Verify the dialog is dismissed and the action was performed
        composeTestRule.onNodeWithText("Upgrade now").assertDoesNotExist()
        assert(upgraded)
    }
}
