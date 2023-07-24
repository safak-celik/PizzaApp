package com.example.pizzaappforcgi.base

import androidx.activity.ComponentActivity

abstract class MviComposeActivity<VM : MviViewModel<out UiIntent, out UiState>> :
    ComponentActivity() {}