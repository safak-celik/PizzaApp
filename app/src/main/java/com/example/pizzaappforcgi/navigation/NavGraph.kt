package com.example.pizzaappforcgi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizzaappforcgi.navigation.BottomBarScreen.PizzaScreen
import com.example.pizzaappforcgi.navigation.BottomBarScreen.WelcomeScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.PizzaDetailsScreen
import com.example.pizzaappforcgi.screens.ViewModel
import com.example.pizzaappforcgi.screens.WelcomeScreen
import com.example.pizzaappforcgi.screens.pizza.AddPizzaScreen
import com.example.pizzaappforcgi.screens.pizza.PizzaDetailsScreen
import com.example.pizzaappforcgi.screens.pizza.PizzaScreen

@Composable
fun BottomNavGraph(navController: NavHostController, viewModel: ViewModel) {
    val pizzaList = viewModel.pizzaList.collectAsState().value

    NavHost(navController = navController, startDestination = WelcomeScreen.route) {
        composable(route = WelcomeScreen.route) {
            WelcomeScreen()
        }
        composable(route = PizzaScreen.route) {
            PizzaScreen(
                pizzas = pizzaList,
                onRemoveClick = {
                    viewModel.deletePizza(it)
                },
                onDetailsClick = {
                    navController.navigate(
                        PizzaDetailsScreen.route + "/$it"
                    )
                }
            )
        }

        composable(route = NavigationScreens.AddPizzaScreen.route) {
            AddPizzaScreen(
                navController = navController,
                onSaveClick = { viewModel.addPizza(it) })
        }
        composable(route = PizzaDetailsScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )) {
            val param = it.arguments?.getInt("id") ?: 0
            PizzaDetailsScreen(id = param, viewModel = viewModel)
        }
    }
}


