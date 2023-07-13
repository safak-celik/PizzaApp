package com.example.pizzaappforcgi.screens.addPizza

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.repository.PizzaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: PizzaRepository) : ViewModel() {
    private val _pizzaList = MutableStateFlow<List<Pizza>>(emptyList())
    val pizzaList = _pizzaList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllPizzas().distinctUntilChanged().collect { listOfPizza ->
                if (listOfPizza.isEmpty()) Log.d("Empty", "List of Pizzas is empty")
                else _pizzaList.value = listOfPizza
            }
        }
    }

    fun addPizza(pizza: Pizza) = viewModelScope.launch {
        repository.addPizza(pizza)
    }

    fun deletePizza(pizza: Pizza) = viewModelScope.launch { repository.deletePizza(pizza) }
}