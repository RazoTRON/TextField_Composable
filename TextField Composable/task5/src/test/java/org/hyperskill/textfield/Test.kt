package org.hyperskill.textfield

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.input.TextFieldValue
import org.hyperskill.textfield.components.*
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
            BlackTextField()
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
            .assert(SemanticsMatcher.expectValue(semStringKey, "text")
                .or(SemanticsMatcher.expectValue(semTextFieldValueKey, "text"))
            )

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semTextFieldColorsContainerKey, Color.Black))

        composeTestRule.onNodeWithTag("TextField")
            .assert(SemanticsMatcher.expectValue(semTextFieldColorsTextKey, Color.White))

    }


}
//@Composable
//fun SayMyName() {
//    Text(
//        text = buildAnnotatedString {
//            withStyle(SpanStyle(color = Color.Black)) {
//                append("Say ")
//            }
//            withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = Color.Black)) {
//                append("my ")
//            }
//            withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.Red)) {
//                append("NAME")
//            }
//        }
//    )
//}