package com.example.pizzaappforcgi.data

import com.example.pizzaappforcgi.model.Pizza

class PizzaData {
    companion object {
        fun loadPizza(): List<Pizza> {
            return listOf(
                Pizza(title = "Salami", description = "Cheese, Tomato Sauce"),
                Pizza(title = "Salami", description = "Cheese, Tomato Sauce"),
                Pizza(title = "Salami", description = "Cheese, Tomato Sauce"),
                Pizza(title = "Salami", description = "Cheese, Tomato Sauce"),
                Pizza(title = "Salami", description = "Cheese, Tomato Sauce"),
                Pizza(title = "Salami", description = "Cheese, Tomato Sauce")
            )
        }
    }
}