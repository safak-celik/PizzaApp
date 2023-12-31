package com.example.pizzaappforcgi

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.pizzaappforcgi.base.MviComposeActivity
import com.example.pizzaappforcgi.presentation.screens.MainScreen
import com.example.pizzaappforcgi.presentation.screens.ViewModel
import com.example.pizzaappforcgi.ui.theme.PizzaAppForCGITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : MviComposeActivity<ViewModel>() {

    override val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppForCGITheme {
                val viewModel: ViewModel by viewModels()
                MainScreen(
                    viewModel = viewModel,
                    state = viewModel.uiState.collectAsState().value,
                )
            }
        }
    }
}