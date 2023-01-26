package org.hyperskill.textfield

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.hyperskill.textfield.components.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class CustomTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testCustomTextField() {
        composeTestRule.setContent {
            CustomTextField()
        }

        composeTestRule.onRoot().printToLog("TEXT_FIELD")
        setUp()

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semUnfocusedIndicatorColorKey, Color.Transparent))

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
            .assert(SemanticsMatcher.expectValue(semErrorIndicatorColorKey, Color.Transparent))

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semDisabledIndicatorColorKey, Color.Transparent))

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semFocusedIndicatorColorKey, Color.Transparent))

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semShapeKey, CutCornerShape(10.dp)))

    }


}