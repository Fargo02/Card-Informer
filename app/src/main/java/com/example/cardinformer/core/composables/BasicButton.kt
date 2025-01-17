package com.example.cardinformer.core.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardinformer.ui.theme.CardInformerTheme

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,

) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = androidx.compose.foundation.shape.CircleShape,
        contentPadding = PaddingValues(18.dp)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun BasicButtonPreview() {
    CardInformerTheme(dynamicColor = false) {
        BasicButton(
            text = "Кнопка",
            onClick = { }
        )
    }
}