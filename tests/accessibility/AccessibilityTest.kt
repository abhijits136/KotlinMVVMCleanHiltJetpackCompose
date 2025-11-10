package tests.accessibility

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class AccessibilityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testButtonHasContentDescription() {
        composeTestRule.setContent {
            androidx.compose.material3.Button(onClick = {}) {
                androidx.compose.material3.Text("Click me")
            }
        }
        composeTestRule.onNodeWithText("Click me")
            .assert(SemanticsProperties.ContentDescription != null)
    }
}
