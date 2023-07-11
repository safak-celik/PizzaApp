package com.example.pizzaappforcgi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizzaappforcgi.screens.AddPizzaScreen
import com.example.pizzaappforcgi.screens.MainScreen

@Composable
fun PizzaNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PizzaScreens.HomeScreen.name) {
        composable(route = PizzaScreens.HomeScreen.name) {
            MainScreen(navController = navController)
        }
        composable(route = PizzaScreens.AddPizzaScreen.name) {
            AddPizzaScreen(navController = navController)
        }
    }
}