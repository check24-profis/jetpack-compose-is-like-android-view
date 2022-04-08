package de.check24.compose.demo

import android.app.Activity

internal data class SingleItem (
    val activity: Class<out Activity>,
    val headline: String
)