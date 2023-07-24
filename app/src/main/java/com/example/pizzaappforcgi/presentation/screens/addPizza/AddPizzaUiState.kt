package com.example.pizzaappforcgi.presentation.screens.addPizza

import com.example.pizzaappforcgi.base.UiState
import com.example.pizzaappforcgi.model.Pizza
import kotlinx.coroutines.flow.MutableStateFlow

data class AddPizzaUiState(
    var pizzaListState: MutableStateFlow<List<Pizza>> = MutableStateFlow(emptyList())
) : UiState
