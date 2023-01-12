package org.hyperskill.textcomposable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class InconsolataTextTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInconsolataText() {
        composeTestRule.setContent {
            InconsolataText(text = "Font text")
        }

        composeTestRule
            .onNodeWithText("Font text", ignoreCase = true)
            .assert(
                SemanticsMatcher.expectValue(semFontFamilyKey, FontFamily(Font(R.font.inconsolata)))
                    .or(
                        SemanticsMatcher.expectValue(
                            semAnnotatedStringSpanStyleKey, SpanStyle(
                                fontFamily = FontFamily(Font(R.font.inconsolata))
                            )
                        )
                    )
            )
    }
}


//@Composable
//fun InconsolataText(text: String) {
////    Text(
////        text = text,
////        fontFamily = FontFamily(Font(R.font.inconsolata))
////    )
//    Text(
//        text = buildAnnotatedString {
//            withStyle(SpanStyle(fontFamily = FontFamily(Font(R.font.inconsolata)))) {
//                append(text)
//            }
//        }
//    )
//}