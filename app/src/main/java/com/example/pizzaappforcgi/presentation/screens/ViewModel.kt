package com.example.pizzaappforcgi.presentation.screens

import androidx.lifecycle.viewModelScope
import com.example.pizzaappforcgi.base.MviViewModel
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.presentation.screens.PizzaUiIntent.AddPizza
import com.example.pizzaappforcgi.presentation.screens.PizzaUiIntent.DeletePizza
import com.example.pizzaappforcgi.repository.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: PizzaRepository) :
    MviViewModel<PizzaUiIntent, PizzaUiState>(
        PizzaUiState(MutableStateFlow(emptyList()))
    ) {
    private val _pizzaList = uiState.value.pizzaListState
    val pizzaList = _pizzaList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllPizzas().distinctUntilChanged().collect { listOfPizza ->
                _pizzaList.value = listOfPizza
            }
        }
    }

    override fun onUiIntent(intent: PizzaUiIntent) {
        when (intent) {
            is DeletePizza -> deletePizza(pizza = intent.pizza)
            is AddPizza -> addPizza(pizza = intent.pizza)
        }
        super.onUiIntent(intent)
    }

    private fun addPizza(pizza: Pizza) = viewModelScope.launch { repository.addPizza(pizza) }

    private fun deletePizza(pizza: Pizza) = viewModelScope.launch { repository.deletePizza(pizza) }
}