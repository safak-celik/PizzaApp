package com.example.pizzaappforcgi.screens.pizza

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizzaappforcgi.components.PizzaRow
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaScreen(
    pizzas: List<Pizza>,
    onRemoveClick: (Pizza) -> Unit,
    onDetailsClick: (Pizza) -> Unit,
) {
    LazyColumn(Modifier.padding(CgiDimens.spacings.spacingXS)) {
        items(items = pizzas) { pizza ->
            PizzaRow(
                pizza = pizza,
                onItemClicked = { onDetailsClick(it) },
                onItemLongClick = { onRemoveClick(it) })
        }
    }
}