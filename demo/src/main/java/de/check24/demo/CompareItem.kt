package de.check24.demo

import android.app.Activity

class CompareItem(
    val composeActivity: Class<out Activity>,
    val androidUIActivity: Class<out Activity>,
    val headline: String
)