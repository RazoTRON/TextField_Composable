package org.hyperskill.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.hyperskill.textfield.components.OutlinedTextField
import org.hyperskill.textfield.components.TextField
import org.hyperskill.textfield.ui.theme.HyperskillTheme

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTextField()
        }
    }
}

var value by mutableStateOf("Custom Text Field")

@Preview
@Composable
fun CustomTextField() {
    HyperskillTheme {
        OutlinedTextField(
            value,
            onValueChange = { value = it },
            shape = CutCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}