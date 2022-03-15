package de.check24.compose.demo.extensions

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity

/**
 * <code>val activity = LocalContext.current.getActivity()</code>
 */
tailrec fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}