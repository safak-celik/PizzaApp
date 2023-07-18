package com.example.pizzaappforcgi.screens

import com.example.pizzaappforcgi.base.UiIntent
import com.example.pizzaappforcgi.model.Pizza

sealed class PizzaUiIntent : UiIntent {
    data class AddPizza(val pizza: Pizza) : PizzaUiIntent()
    data class DeletePizza(val pizza: Pizza) : PizzaUiIntent()
}