package tests.ui

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class SampleUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSampleUi() {
        // TODO: Add Compose UI test
        composeTestRule.setContent {
            // Your composable here
        }
        // Add assertions
    }
}
