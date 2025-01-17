package com.example.cardinformer.core.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String,
    placeHolderText: String,
    singleLine: Boolean = false,
    placeholderTextColor: Color = MaterialTheme.colorScheme.onSecondary,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    disabledBorderColor: Color = MaterialTheme.colorScheme.onPrimary,
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.onPrimary,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeHolderText,
                color = placeholderTextColor
            )
        },
        singleLine = singleLine,
        textStyle = TextStyle(textColor, fontSize = 16.sp),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledBorderColor = disabledBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
            focusedBorderColor = focusedBorderColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
    )
}