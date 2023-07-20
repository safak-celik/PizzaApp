package com.example.pizzaappforcgi.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 2,
    onTextChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(containerColor = Transparent),
        maxLines = maxLine,
        label = { Text(text = label) }
    )
}