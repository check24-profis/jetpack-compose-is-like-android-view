package de.check24.compose.demo.features.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.theme.Grey3
import de.check24.compose.demo.theme.Grey6
import de.check24.compose.demo.theme.Grey9

internal val exampleTypography: Typography
    get() = Typography(
        h1 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 28.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        h2 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        h3 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        h4 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        h5 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Grey9,
            letterSpacing = 0.sp
        ),
        h6 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        subtitle1 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        subtitle2 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        body1 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        body2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Grey9,
            letterSpacing = 0.sp
        ),
        button = TextStyle(
            fontSize = 16.sp,
            lineHeight = 18.sp,
            color = Color.White,
            letterSpacing = 0.sp
        ),
        caption = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Grey3,
            letterSpacing = 0.sp
        )
    )