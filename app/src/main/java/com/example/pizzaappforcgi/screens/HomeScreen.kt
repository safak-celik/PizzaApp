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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaappforcgi.R
import com.example.pizzaappforcgi.screens.NavigationBarItems.HOME
import com.example.pizzaappforcgi.screens.NavigationBarItems.PIZZA
import com.example.pizzaappforcgi.ui.theme.CgiDimens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navigationBarItems = remember { NavigationBarItems.values() }
    var selectIndex by remember { mutableStateOf(0) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        },
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .padding(
                        bottom = CgiDimens.spacings.spacingM,
                        start = CgiDimens.spacings.spacingM,
                        end =  CgiDimens.spacings.spacingM
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
                    HOME -> WelcomeScreen()
                    PIZZA -> PizzaScreen()
                }
            }
        }
    )
}


enum class NavigationBarItems(val icon: Int) {
    HOME(R.drawable.ic_home),
    PIZZA(R.drawable.ic_food)
}

const val Duration = 500