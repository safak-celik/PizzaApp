package com.example.pizzaappforcgi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.pizzaappforcgi.navigation.PizzaNavigation
import com.example.pizzaappforcgi.ui.theme.PizzaAppForCGITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp { PizzaNavigation() }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    PizzaAppForCGITheme {
        content()
    }
}
