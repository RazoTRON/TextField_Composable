package org.hyperskill.textcomposable

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MessageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMultiLine() {
        composeTestRule.setContent {
            SingleLine("First line\nThis is the second line")
        }

        composeTestRule
            .onNodeWithText("First line", substring = true, ignoreCase = true)
            .assert(SemanticsMatcher.expectValue(semMaxLinesKey, 1))
            .assert(SemanticsMatcher.expectValue(semOverflowKey, TextOverflow.Ellipsis))
    }
}

//@Composable
//fun SingleLine(text: String) {
//    Text(
//        text = text,
//        maxLines = 1,
//        overflow = TextOverflow.Ellipsis
//    )
//}
//
//@Preview
//@Composable
//fun PreviewShortLine() {
//    SingleLine(text = "some txt\nsdkkljkljlkfsd")
//}