package org.hyperskill.textfield

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.input.PasswordVisualTransformation
import org.hyperskill.textfield.components.semStringKey
import org.hyperskill.textfield.components.semTextFieldValueKey
import org.hyperskill.textfield.components.semVisualTransformationKey
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

        composeTestRule.onRoot().printToLog("TEXT_FIELD")
        setUp()

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

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semVisualTransformationKey, PasswordVisualTransformation(mask = 'X')))

    }


}