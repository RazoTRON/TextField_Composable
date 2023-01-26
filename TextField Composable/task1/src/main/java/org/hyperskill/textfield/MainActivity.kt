package org.hyperskill.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import org.hyperskill.textfield.components.TextField
import org.hyperskill.textfield.components.OutlinedTextField
import org.hyperskill.textfield.ui.theme.HyperskillTheme

// DO NOT import TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordField()
        }
    }
}

var value by mutableStateOf("423")

@Composable
fun PasswordField() {
    TextField(
        value,
        onValueChange = { value = it },
        visualTransformation = PasswordVisualTransformation(mask = 'X'),
        singleLine = true,
    )
}

@Preview
@Composable
fun PasswordFieldPreview() {
    HyperskillTheme {
        PasswordField()
    }
}