package com.example.pizzaappforcgi.presentation.screens.pizza

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.pizzaappforcgi.components.PizzaRow
import com.example.pizzaappforcgi.presentation.screens.PizzaUiIntent.DeletePizza
import com.example.pizzaappforcgi.presentation.screens.ViewModel
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaScreen(
    viewModel: ViewModel,
    onDetailsClick: (Int) -> Unit
) {
    val pizzaList = viewModel.pizzaList.collectAsState().value

    LazyColumn(Modifier.padding(CgiDimens.spacings.spacingXS)) {
        items(items = pizzaList) { pizza ->
            PizzaRow(
                pizza = pizza,
                onItemClicked = { onDetailsClick(pizza.id) },
                onItemLongClick = { viewModel.sendIntent(DeletePizza(it)) })
        }
    }
}