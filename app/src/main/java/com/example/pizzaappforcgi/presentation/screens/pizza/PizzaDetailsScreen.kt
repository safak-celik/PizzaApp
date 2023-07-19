package com.example.pizzaappforcgi.presentation.screens.pizza

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp
import com.example.pizzaappforcgi.R
import com.example.pizzaappforcgi.presentation.screens.ViewModel
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaDetailsScreen(id: Int, viewModel: ViewModel) {
    val pizza = viewModel.pizzaList.collectAsState().value.first { pizza -> pizza.id == id }

    Column(
        Modifier
            .fillMaxSize()
            .padding(CgiDimens.spacings.spacingS),
        horizontalAlignment = Start
    ) {
        Image(
            modifier = Modifier
                .size(CgiDimens.imageSize.imageSizeXl)
                .align(CenterHorizontally),
            painter = painterResource(id = R.drawable.pizza), contentDescription = "Image"
        )
        Text(
            text = pizza.title,
            modifier = Modifier.padding(vertical = CgiDimens.spacings.spacingS),
            style = TextStyle(fontWeight = Bold, fontSize = 24.sp)
        )
        Text(
            text = pizza.description,
            modifier = Modifier.padding(vertical = CgiDimens.spacings.spacingS),
            style = TextStyle(fontSize = 20.sp)
        )
    }
}