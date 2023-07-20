package com.example.pizzaappforcgi.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pizzaappforcgi.R
import com.example.pizzaappforcgi.components.TopBar
import com.example.pizzaappforcgi.navigation.BottomBarScreen
import com.example.pizzaappforcgi.navigation.BottomBarScreen.PizzaScreen
import com.example.pizzaappforcgi.navigation.BottomBarScreen.WelcomeScreen
import com.example.pizzaappforcgi.navigation.BottomNavGraph
import com.example.pizzaappforcgi.navigation.NavigationScreens.AddPizzaScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.PizzaDetailsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: PizzaUiState = PizzaUiState(),
    viewModel: ViewModel
) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                addButtonIsVisibility = currentRoute == state.addButtonVisibility,
                backButtonIsVisibility = currentRoute == state.backButtonVisibility,
                title = when (currentRoute) {
                    WelcomeScreen.route -> stringResource(id = R.string.app_bar_title)
                    PizzaScreen.route -> stringResource(id = R.string.app_bar_title_pizza)
                    AddPizzaScreen.route -> stringResource(id = R.string.app_bar_add_pizza_title)
                    PizzaDetailsScreen.route -> stringResource(id = R.string.app_bar_pizza_details_title)
                    else -> stringResource(id = R.string.app_bar_title)
                },
                onAddButtonClick = { navController.navigate(AddPizzaScreen.route) },
                onBackButtonClick = { navController.popBackStack() }
            )
        },
        bottomBar = { BottomBar(navHostController = navController) })
    { paddings ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(
                    top = paddings.calculateTopPadding(),
                    bottom = paddings.calculateBottomPadding()
                )
        ) {
            BottomNavGraph(navController = navController, viewModel = viewModel)
        }
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        WelcomeScreen,
        PizzaScreen
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = colorResource(id = R.color.purple_200)
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBarItem(
        label = { Text(text = screen.title) },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = "Icon") },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navHostController.navigate(screen.route) {
                if (currentRoute == PizzaScreen.route) {
                    popUpTo(navHostController.graph.id) {
                        inclusive = true
                    }
                }
            }
        }
    )
}