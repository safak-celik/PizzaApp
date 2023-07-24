package com.example.pizzaappforcgi.presentation.screens.addPizza

import com.example.pizzaappforcgi.base.UiIntent
import com.example.pizzaappforcgi.model.Pizza

sealed class AddPizzaUiIntent : UiIntent {
    data class AddPizza(val pizza: Pizza) : AddPizzaUiIntent()
}