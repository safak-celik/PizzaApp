package com.example.pizzaappforcgi.presentation.screens.pizza

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.pizzaappforcgi.components.PizzaRow
import com.example.pizzaappforcgi.presentation.screens.pizza.PizzaUiIntent.DeletePizza
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaScreen(
    onDetailsClick: (Int) -> Unit
) {

    val viewModel = hiltViewModel<PizzaViewModel>()
    val uiState by viewModel.pizzaList.collectAsStateWithLifecycle()

    LazyColumn(Modifier.padding(CgiDimens.spacings.spacingXS)) {
        items(items = uiState) { pizza ->
            PizzaRow(
                pizza = pizza,
                onItemClicked = { onDetailsClick(pizza.id) },
                onItemLongClick = { viewModel.sendIntent(DeletePizza(it)) })
        }
    }
}