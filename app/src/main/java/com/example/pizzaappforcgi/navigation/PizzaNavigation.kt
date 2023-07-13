package com.example.pizzaappforcgi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizzaappforcgi.navigation.NavigationScreens.AddPizzaScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.HomeScreen
import com.example.pizzaappforcgi.screens.addPizza.AddPizzaScreen
import com.example.pizzaappforcgi.screens.MainScreen
import com.example.pizzaappforcgi.screens.addPizza.ViewModel

@Composable
fun PizzaNavigation(viewModel: ViewModel) {

    val navController = rememberNavController()
    val pizzaList = viewModel.pizzaList.collectAsState().value

    NavHost(navController = navController, startDestination = HomeScreen.name) {
        composable(route = HomeScreen.name) {
            MainScreen(navController = navController, pizzaList, viewModel = viewModel)
        }
        composable(route = AddPizzaScreen.name) {
            AddPizzaScreen(
                navController = navController,
                onSaveClick = { viewModel.addPizza(it) })
        }
    }
}

enum class NavigationScreens {
    HomeScreen,
    AddPizzaScreen
}