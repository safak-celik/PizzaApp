package com.example.pizzaappforcgi.navigation

import androidx.annotation.DrawableRes
import com.example.pizzaappforcgi.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {
    object WelcomeScreen : BottomBarScreen(
        route = "WelcomeScreen",
        title = "Welcome",
        icon = R.drawable.ic_home
    )

    object PizzaScreen : BottomBarScreen(
        route = "PizzaScreen",
        title = "Pizza",
        icon = R.drawable.ic_food
    )
}

sealed class NavigationScreens(
    val route: String
) {
    object AddPizzaScreen : NavigationScreens(
        route = "AddPizzaScreen"
    )

    object PizzaDetailsScreen : NavigationScreens(
        route = "PizzaDetailsScreen"
    )
}