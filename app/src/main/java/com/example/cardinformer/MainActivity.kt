package com.example.cardinformer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cardinformer.navigation.Navigation
import com.example.cardinformer.ui.theme.CardInformerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardInformerTheme {
                Navigation()
            }
        }
    }
}