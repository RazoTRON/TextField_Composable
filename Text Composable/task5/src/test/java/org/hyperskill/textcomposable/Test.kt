package org.hyperskill.textcomposable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MessageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSayMyName() {
        composeTestRule.setContent {
            SayMyName()
        }

        val say = AnnotatedString.Range(SpanStyle(color = Color.Black), 0, 3)
        val my = AnnotatedString.Range(
            SpanStyle(fontWeight = FontWeight.SemiBold, color = Color.Black),
            0,
            2
        )
        val name = AnnotatedString.Range(
            SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.Red),
            0,
            4
        )

        composeTestRule
            .onNodeWithText("say my name", ignoreCase = true)
            .assert(SemanticsMatcher.expectValue(semAnnotatedString03Key, listOf(say)))
            .assert(SemanticsMatcher.expectValue(semAnnotatedString46Key, listOf(my)))
            .assert(SemanticsMatcher.expectValue(semAnnotatedString711Key, listOf(name)))
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