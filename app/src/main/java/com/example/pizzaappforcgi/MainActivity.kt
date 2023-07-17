package com.example.pizzaappforcgi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.pizzaappforcgi.navigation.PizzaNavigation
import com.example.pizzaappforcgi.screens.ViewModel
import com.example.pizzaappforcgi.ui.theme.PizzaAppForCGITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppForCGITheme {
                val viewModel: ViewModel by viewModels()
                PizzaApp { PizzaNavigation(viewModel) }
            }
        }
    }
}

@Composable
fun PizzaApp(
    content: @Composable () -> Unit
) {
    content()
}
