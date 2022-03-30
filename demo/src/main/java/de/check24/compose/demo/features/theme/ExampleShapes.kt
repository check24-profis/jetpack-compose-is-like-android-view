package de.check24.compose.demo.features.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

internal val exampleShapes: Shapes
    get() = Shapes(
        small = RoundedCornerShape(0.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp)
    )