package com.example.pizzaappforcgi.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.pizzaappforcgi.ui.theme.CgiDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    addButtonIsVisibility: Boolean = false,
    backButtonIsVisibility: Boolean = false,
    onAddButtonClick: () -> Unit ,
    onBackButtonClick: () -> Unit,
    title: String
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (backButtonIsVisibility) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = CgiDimens.spacings.spacingXS)
                        .clickable { onBackButtonClick() },
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back Button",
                    tint = White
                )
            }
        },
        actions = {
            if (addButtonIsVisibility) {
                Icon(
                    modifier = Modifier.clickable {
                        onAddButtonClick()
                    },
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Button",
                    tint = White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = White,
        )
    )
}