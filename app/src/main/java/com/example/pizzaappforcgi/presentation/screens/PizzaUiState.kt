package com.example.pizzaappforcgi.presentation.screens

import com.example.pizzaappforcgi.base.UiState
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.navigation.BottomBarScreen.PizzaScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.PizzaDetailsScreen
import kotlinx.coroutines.flow.MutableStateFlow

data class PizzaUiState(
    var pizzaListState: MutableStateFlow<List<Pizza>> = MutableStateFlow(emptyList())
) : UiState {
    val addButtonVisibility = PizzaScreen.route
    val backButtonVisibility = PizzaDetailsScreen.route + "/{id}"
}
