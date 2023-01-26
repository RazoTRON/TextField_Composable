package org.hyperskill.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import org.hyperskill.textfield.components.TextField

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchField()
        }
    }
}

var value by mutableStateOf("")

@Preview
@Composable
fun SearchField() {
    Column {
        TextField(
            value = value,
            onValueChange = {
                if (it.contains(Regex("^\\d+$"))) {
                    value = it
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "leadingIcon")
            },
            trailingIcon = {
                Icon(Icons.Default.Search, "trailingIcon")
            }
        )
    }
}