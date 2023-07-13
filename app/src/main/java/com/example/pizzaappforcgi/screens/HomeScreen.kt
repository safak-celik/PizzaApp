package com.example.pizzaappforcgi.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pizzaappforcgi.R
import com.example.pizzaappforcgi.components.TopBar
import com.example.pizzaappforcgi.model.Pizza
import com.example.pizzaappforcgi.navigation.NavigationScreens
import com.example.pizzaappforcgi.screens.NavigationBarItems.PIZZA
import com.example.pizzaappforcgi.screens.NavigationBarItems.WELCOME
import com.example.pizzaappforcgi.screens.addPizza.ViewModel
import com.example.pizzaappforcgi.ui.theme.CgiDimens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, pizzas: List<Pizza>, viewModel: ViewModel) {

    val navigationBarItems = remember { NavigationBarItems.values() }
    var selectIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                addButtonIsVisibility = selectIndex == 1,
                title = if (selectIndex == 0) {
                    stringResource(id = R.string.app_bar_title)
                } else {
                    stringResource(id = R.string.app_bar_title_pizza)
                },
                onAddButtonClick = {
                    navigateToAddPizzaScreen(navController)
                }
            )
        },
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .padding(
                        bottom = CgiDimens.spacings.spacingS,
                        start = CgiDimens.spacings.spacingM,
                        end = CgiDimens.spacings.spacingM
                    )
                    .height(64.dp),
                selectedIndex = selectIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = CgiDimens.cornerSizes.cornerSizeL),
                ballAnimation = Parabolic(tween(Duration)),
                indentAnimation = Height(tween(Duration)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationBarItems.forEach { item ->
                    val icon = painterResource(id = item.icon)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable { selectIndex = item.ordinal },
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            modifier = Modifier.size(CgiDimens.iconSize.iconSizeL),
                            painter = icon,
                            contentDescription = "Bottom Bar Icon",
                            tint = if (selectIndex == item.ordinal) Color.White
                            else LightGray,
                        )
                    }
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
            ) {
                when (navigationBarItems[selectIndex]) {
                    WELCOME -> WelcomeScreen()
                    PIZZA -> PizzaScreen(pizzas = pizzas, onRemoveClicked = {
                        viewModel.deletePizza(it)
                    })
                }
            }
        }
    )
}


enum class NavigationBarItems(val icon: Int) {
    WELCOME(R.drawable.ic_home),
    PIZZA(R.drawable.ic_food)
}

private fun navigateToAddPizzaScreen(navController: NavController) {
    navController.navigate(route = NavigationScreens.AddPizzaScreen.name)
}

const val Duration = 250