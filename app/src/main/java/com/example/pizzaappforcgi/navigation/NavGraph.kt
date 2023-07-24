package com.example.pizzaappforcgi.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizzaappforcgi.navigation.BottomBarScreen.PizzaScreen
import com.example.pizzaappforcgi.navigation.BottomBarScreen.WelcomeScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.AddPizzaScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.PizzaDetailsScreen
import com.example.pizzaappforcgi.presentation.screens.pizza.PizzaViewModel
import com.example.pizzaappforcgi.presentation.screens.WelcomeScreen
import com.example.pizzaappforcgi.presentation.screens.addPizza.AddPizzaScreen
import com.example.pizzaappforcgi.presentation.screens.PizzaDetailsScreen
import com.example.pizzaappforcgi.presentation.screens.pizza.PizzaScreen

@Composable
fun BottomNavGraph(navController: NavHostController, viewModel: PizzaViewModel = hiltViewModel()) {

    NavHost(navController = navController, startDestination = WelcomeScreen.route) {
        composable(route = WelcomeScreen.route) {
            WelcomeScreen()
        }
        composable(route = PizzaScreen.route) {
            PizzaScreen(
                onDetailsClick = { navController.navigate(PizzaDetailsScreen.route + "/$it") }
            )
        }

        composable(route = AddPizzaScreen.route) {
            AddPizzaScreen(navController = navController)
        }
        composable(
            route = PizzaDetailsScreen.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val param = it.arguments?.getInt("id") ?: 0
            PizzaDetailsScreen(id = param, viewModel = viewModel)
        }
    }
}


