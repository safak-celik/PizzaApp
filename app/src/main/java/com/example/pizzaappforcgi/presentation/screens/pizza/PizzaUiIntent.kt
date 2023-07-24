package com.example.pizzaappforcgi.presentation.screens.pizza

import com.example.pizzaappforcgi.base.UiIntent
import com.example.pizzaappforcgi.model.Pizza

sealed class PizzaUiIntent : UiIntent {
    data class DeletePizza(val pizza: Pizza) : PizzaUiIntent()
}