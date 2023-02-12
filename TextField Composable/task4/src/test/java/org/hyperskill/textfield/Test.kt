package org.hyperskill.textfield

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.hyperskill.textfield.components.semIsErrorKey
import org.hyperskill.textfield.components.semPlaceholderKey
import org.hyperskill.textfield.components.semStringKey
import org.hyperskill.textfield.components.semTextFieldValueKey
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class PasswordFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testPasswordField() {
        composeTestRule.setContent {
            PasswordField()
        }


        composeTestRule.onRoot(true).printToLog("TEXT_FIELD")
        setUp()


        composeTestRule.onNodeWithTag("TextField", useUnmergedTree = true)
            .assert(SemanticsMatcher.expectValue(semPlaceholderKey, null).not())

        composeTestRule.onNodeWithTag("Text", useUnmergedTree = true).assertTextEquals("Password")

        composeTestRule.onNodeWithTag("TextField", useUnmergedTree = true).performClick()
            .performTextClearance()

        composeTestRule.onNodeWithTag("TextField", useUnmergedTree = true)
            .assert(
                SemanticsMatcher.expectValue(semStringKey, "")
                        or
                        SemanticsMatcher.expectValue(semTextFieldValueKey, "")
            )

        composeTestRule.onNodeWithTag("TextField", useUnmergedTree = true).performClick()
            .performTextInput("pass")

        composeTestRule.onNodeWithTag("TextField", useUnmergedTree = true)
            .assert(
                SemanticsMatcher.expectValue(semStringKey, "pass")
                        or
                        SemanticsMatcher.expectValue(semTextFieldValueKey, "pass")
            )

        composeTestRule.onNodeWithTag("TextField").assert(
            SemanticsMatcher.expectValue(semIsErrorKey, true)
        )

        composeTestRule.onNodeWithTag("TextField", useUnmergedTree = true).performClick()
            .performTextInput("word")

        composeTestRule.onNodeWithTag("TextField").assert(
            SemanticsMatcher.expectValue(semIsErrorKey, false)
        )


    }


}