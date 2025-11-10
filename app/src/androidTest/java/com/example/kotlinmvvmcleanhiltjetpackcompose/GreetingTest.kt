package com.example.kotlinmvvmcleanhiltjetpackcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.theme.KotlinMVVMCleanHiltJetpackComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greeting_displaysCorrectText() {
        composeTestRule.setContent {
            KotlinMVVMCleanHiltJetpackComposeTheme {
                //Greeting("Gemini")
            }
        }
        composeTestRule.onNodeWithText("Hello Gemini!").assertExists()
    }

    @Test
    fun theme_isAppliedToGreeting() {
        composeTestRule.setContent {
            KotlinMVVMCleanHiltJetpackComposeTheme(darkTheme = false) {
                //Greeting("Themed")
            }
        }
        composeTestRule.onNodeWithText("Hello Themed!").assertIsDisplayed()
    }
}
