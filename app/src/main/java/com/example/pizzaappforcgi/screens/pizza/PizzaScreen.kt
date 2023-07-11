package com.example.pizzaappforcgi.screens.pizza

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizzaappforcgi.components.PizzaRow
import com.example.pizzaappforcgi.data.PizzaData
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaScreen(
    onRemoveClicked: (Pizza) -> Unit = {},
) {
    val listOfPizza = PizzaData.loadPizza()

    LazyColumn(Modifier.padding(CgiDimens.spacings.spacingXS)) {
        items(listOfPizza) { pizza ->
            PizzaRow(pizza = pizza, onPizzaClicked = {
                onRemoveClicked(it)
            })
        }
    }
}