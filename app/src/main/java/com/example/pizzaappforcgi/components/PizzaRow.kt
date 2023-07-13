package com.example.pizzaappforcgi.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.example.pizzaappforcgi.R
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@Composable
fun PizzaRow(
    modifier: Modifier = Modifier,
    pizza: Pizza,
    onItemClicked: (Pizza) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(CgiDimens.cornerSizes.cornerSizeS)),
        border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.purple_700)),
        color = colorResource(id = R.color.purple_200)
    ) {
        Row(
            modifier = Modifier
                .clickable { onItemClicked(pizza) }
                .padding(CgiDimens.spacings.spacingXS),
        ) {
            Image(
                modifier = Modifier
                    .size(84.dp)
                    .padding(horizontal = CgiDimens.spacings.spacingM),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.pizza), contentDescription = "Image"
            )
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = pizza.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = Bold
                )
                Text(
                    modifier = Modifier.padding(top = CgiDimens.spacings.spacingXS),
                    text = pizza.description,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}