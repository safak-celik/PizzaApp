package com.example.pizzaappforcgi.navigation

import java.lang.IllegalArgumentException

enum class PizzaScreens {
    HomeScreen,
    AddPizzaScreen;

    companion object {
        fun fromRoute(route: String?): PizzaScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            AddPizzaScreen.name -> AddPizzaScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}