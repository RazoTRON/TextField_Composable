package org.hyperskill.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import org.hyperskill.textfield.components.Text
import org.hyperskill.textfield.components.TextField
import org.hyperskill.textfield.ui.theme.HyperskillTheme

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordField()
        }
    }
}

var value by mutableStateOf("")

@Preview
@Composable
fun PasswordField() {
    HyperskillTheme {
        TextField(
            value,
            onValueChange = {
                value = it
            },
            isError = value.length < 8,
            placeholder = { Text("Password") }
        )
    }
}