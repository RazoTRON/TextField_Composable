package org.hyperskill.textfield

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.hyperskill.textfield.components.semLeadingIconKey
import org.hyperskill.textfield.components.semStringKey
import org.hyperskill.textfield.components.semTextFieldValueKey
import org.hyperskill.textfield.components.semTrailingIconKey
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class SearchFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testSearchField() {
        composeTestRule.setContent {
            SearchField()
        }

        composeTestRule.onRoot(true).printToLog("TEXT_FIELD")
        setUp()

        composeTestRule.onNodeWithContentDescription("leadingIcon", ignoreCase = true, useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithContentDescription("trailingIcon", ignoreCase = true, useUnmergedTree = true).assertExists()

        composeTestRule.onNodeWithTag("TextField").performClick().performTextClearance()

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semStringKey, "")
                .or(SemanticsMatcher.expectValue(semTextFieldValueKey, ""))
            )

        composeTestRule.onNodeWithTag("TextField").performClick().performTextInput("text")

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semStringKey, "")
                .or(SemanticsMatcher.expectValue(semTextFieldValueKey, ""))
            )

        composeTestRule.onNodeWithTag("TextField").performClick().performTextInput("0123459876")

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semStringKey, "0123459876")
                .or(SemanticsMatcher.expectValue(semTextFieldValueKey, "0123459876"))
            )

    }


}