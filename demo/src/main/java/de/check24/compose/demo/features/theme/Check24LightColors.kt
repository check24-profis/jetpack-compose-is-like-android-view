package de.check24.compose.demo.features.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

internal val exampleColors: Colors
    get() = lightColors(
        primary = Color(0xFF862A8A),
        primaryVariant = Color(0xFFC280D5),
        onPrimary = Color(0xFFFFFFFF),

        secondary = Color(0xFFFF30FC),
        secondaryVariant = Color(0xFAEAF7FB),
        onSecondary = Color(0xFFFFFFFF),

        error = Color(0xFFC82D70),
        onError = Color(0xFFFFFFFF),

        surface = Color(0xFFFFFFFF),
        onSurface = Color(0xFF333333),

        background = Color(0xFCEFEFF3),
        onBackground = Color(0xFFFFFFFF)
    )