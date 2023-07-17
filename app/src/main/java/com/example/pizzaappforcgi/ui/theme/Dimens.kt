package com.example.pizzaappforcgi.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val spacings: Spacing = Spacing(),
    val cornerSizes: CornerSizes = CornerSizes(),
    val iconSize: IconSize = IconSize(),
    val imageSize: ImageSize = ImageSize()
)

data class Spacing(
    val spacingXS: Dp = 8.dp,
    val spacingS: Dp = 12.dp,
    val spacingM: Dp = 16.dp,
    val spacingL: Dp = 24.dp,
    val spacingXl: Dp = 32.dp,
)

data class ImageSize(
    val imageSizeM: Dp = 84.dp,
    val imageSizeXl: Dp = 168.dp
)

data class CornerSizes(
    val cornerSizeS: Dp = 8.dp,
    val cornerSizeL: Dp = 24.dp,
)

data class IconSize(
    val iconSizeL: Dp = 24.dp
)

val LocalDimens = compositionLocalOf { Dimens() }

val CgiDimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current
