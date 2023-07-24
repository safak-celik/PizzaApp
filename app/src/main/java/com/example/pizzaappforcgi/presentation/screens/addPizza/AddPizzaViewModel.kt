package com.example.pizzaappforcgi.presentation.screens.addPizza

import androidx.lifecycle.viewModelScope
import com.example.pizzaappforcgi.base.MviViewModel
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.presentation.screens.addPizza.AddPizzaUiIntent.AddPizza
import com.example.pizzaappforcgi.repository.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPizzaViewModel @Inject constructor(private val repository: PizzaRepository) :
    MviViewModel<AddPizzaUiIntent, AddPizzaUiState>(
        AddPizzaUiState(MutableStateFlow(emptyList()))
    ) {

    override fun onUiIntent(intent: AddPizzaUiIntent) {
        when (intent) {
            is AddPizza -> addPizza(pizza = intent.pizza)
        }
        super.onUiIntent(intent)
    }

    private fun addPizza(pizza: Pizza) = viewModelScope.launch { repository.addPizza(pizza) }
}