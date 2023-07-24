package com.example.pizzaappforcgi

import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.pizzaappforcgi.base.MviComposeActivity
import com.example.pizzaappforcgi.presentation.screens.MainScreen
import com.example.pizzaappforcgi.presentation.screens.pizza.PizzaViewModel
import com.example.pizzaappforcgi.ui.theme.PizzaAppForCGITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : MviComposeActivity<PizzaViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppForCGITheme {
                MainScreen()
            }
        }
    }
}