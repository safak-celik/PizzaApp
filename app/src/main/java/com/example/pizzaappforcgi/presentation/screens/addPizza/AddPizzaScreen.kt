package com.example.pizzaappforcgi.presentation.screens.addPizza

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pizzaappforcgi.components.InputTextField
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.presentation.screens.addPizza.AddPizzaUiIntent.AddPizza
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPizzaScreen(
    navController: NavController
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val addPizzaViewModel = hiltViewModel<AddPizzaViewModel>()

    Scaffold(modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Column(Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding()
                        ),
                    horizontalAlignment = CenterHorizontally
                ) {
                    InputTextField(
                        modifier = Modifier.padding(CgiDimens.spacings.spacingXS),
                        text = title, label = "Pizza",
                        onTextChange = { title = it })
                    InputTextField(
                        modifier = Modifier.padding(CgiDimens.spacings.spacingXS),
                        text = description, label = "Description",
                        onTextChange = { description = it })
                    Button(
                        onClick = {
                            addPizzaViewModel.sendIntent(
                                AddPizza(Pizza(title = title, description = description))
                            )
                            navController.popBackStack()
                        },
                        enabled = title.isNotEmpty() && description.isNotEmpty()
                    ) {
                        Text(text = "Add Pizza")
                    }
                    Button(modifier = Modifier.padding(CgiDimens.spacings.spacingS),
                        onClick = { navController.popBackStack() })
                    {
                        Text(text = "Cancel")
                    }
                }
            }
        }
    )
}