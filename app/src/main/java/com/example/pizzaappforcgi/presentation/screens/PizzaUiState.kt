package com.example.pizzaappforcgi.presentation.screens

import com.example.pizzaappforcgi.base.UiState
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.navigation.BottomBarScreen.PizzaScreen
import com.example.pizzaappforcgi.navigation.NavigationScreens.PizzaDetailsScreen

data class PizzaUiState(
    var pizzaListState: List<Pizza> = emptyList(),
    val isAddPizzaScreenOpen: Boolean = false,
    val isPizzaDetailsScreenOpen: Boolean = false
) : UiState {
    val addButtonVisibility = PizzaScreen.route
    val backButtonVisibility = PizzaDetailsScreen.route + "/{id}"
}
