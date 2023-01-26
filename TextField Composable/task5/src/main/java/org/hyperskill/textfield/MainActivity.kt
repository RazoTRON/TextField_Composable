package org.hyperskill.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import org.hyperskill.textfield.components.*

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackTextField()
        }
    }
}

var value by mutableStateOf(TextFieldValue("Black Text Field"))

@Preview
@Composable
fun BlackTextField() {
    TextField(
        value = value,
        onValueChange = { value = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            containerColor = Color.Black
        )
    )
}