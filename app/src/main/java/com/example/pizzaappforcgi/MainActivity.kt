package com.example.pizzaappforcgi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pizzaappforcgi.screens.MainScreen
import com.example.pizzaappforcgi.ui.theme.PizzaAppForCGITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppForCGITheme {
                MainScreen()
            }
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
