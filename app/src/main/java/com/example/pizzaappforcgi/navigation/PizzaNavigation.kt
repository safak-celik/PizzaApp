package com.example.pizzaappforcgi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizzaappforcgi.screens.addPizza.AddPizzaScreen
import com.example.pizzaappforcgi.screens.MainScreen
import com.example.pizzaappforcgi.screens.addPizza.ViewModel

@Composable
fun PizzaNavigation(viewModel: ViewModel) {

    val navController = rememberNavController()
    val pizzaList = viewModel.pizzaList.collectAsState().value

    NavHost(navController = navController, startDestination = PizzaScreens.HomeScreen.name) {
        composable(route = PizzaScreens.HomeScreen.name) {
            MainScreen(navController = navController, pizzaList, viewModel = viewModel)
        }
        composable(route = PizzaScreens.AddPizzaScreen.name) {
            AddPizzaScreen(
                navController = navController,
                onSaveClick = { viewModel.addPizza(it) })
        }
    }
}