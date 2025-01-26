package com.example.cardinformer.core.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinformer.R
import com.example.cardinformer.ui.theme.CardInformerTheme
import java.lang.Error

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String,
    placeHolderText: String,
    singleLine: Boolean = false,
    placeholderTextColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    disabledBorderColor: Color = MaterialTheme.colorScheme.onPrimary,
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.onPrimary,
    focusedBorderColor: Color = MaterialTheme.colorScheme.tertiary,
    onValueChange: (String) -> Unit,
    isError: Boolean = false
) {

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        isError = isError,
        placeholder = {
            Text(
                text = placeHolderText,
                color = placeholderTextColor
            )
        },
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = stringResource(R.string.clear_text),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
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
            keyboardType = KeyboardType.Number
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTextField() {
    CardInformerTheme(dynamicColor = false) {
        TextField(
            text = "test",
            placeHolderText = "Title",
            onValueChange = {}
        )
    }
}