package com.example.pizzaappforcgi.screens

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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.pizzaappforcgi.R
import com.example.pizzaappforcgi.components.PizzaInputText
import com.example.pizzaappforcgi.components.TopBar
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPizzaScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(id = R.string.app_bar_add_pizza_title),
                onBackButtonClick = { navController.popBackStack() },
                backButtonIsVisibility = true
            )
        },
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
                    PizzaInputText(
                        modifier = Modifier.padding(CgiDimens.spacings.spacingXS),
                        text = title, label = "Pizza",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) title = it
                        })
                    PizzaInputText(
                        modifier = Modifier.padding(CgiDimens.spacings.spacingXS),
                        text = description, label = "Description",
                        onTextChange = {
                            if (it.all { char ->
                                    char.isLetter() || char.isWhitespace()
                                }) description = it
                        })
                    Button(
                        onClick = { navController.popBackStack() },
                        enabled = title.isNotEmpty() && description.isNotEmpty()
                    ) {
                        Text(text = "Add Pizza")
                    }
                }
            }
        }
    )
}