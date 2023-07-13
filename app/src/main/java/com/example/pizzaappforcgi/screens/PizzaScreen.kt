package com.example.pizzaappforcgi.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.pizzaappforcgi.components.PizzaRow
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaScreen(
    pizzas: List<Pizza>,
    onRemoveClicked: (Pizza) -> Unit = {}
) {
    LazyColumn(Modifier.padding(CgiDimens.spacings.spacingXS)) {
        items(pizzas) { pizza ->
            PizzaRow(pizza = pizza, onItemClicked = {
                onRemoveClicked(it)
            })
        }
    }
}