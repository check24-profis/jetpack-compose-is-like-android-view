package de.check24.compose.demo.features.sideeffects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.check24.compose.demo.theme.DemoTheme

class ComposableLaunchedEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                LaunchedEffectDemo()
            }
        }
    }
}

@Composable
private fun LaunchedEffectDemo() {
    var isSnackbarVisible by remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    if (isSnackbarVisible) {

        //LaunchedEffect Safely executes suspends funs
        LaunchedEffect(scaffoldState.snackbarHostState) {

            //showSnackbar is a suspend fun
            scaffoldState.snackbarHostState.showSnackbar(
                message = "this is a snackbar",
                actionLabel = "hide"
            )

            isSnackbarVisible = scaffoldState.snackbarHostState.currentSnackbarData != null
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            TopAppBar(
                title = { Text(text = "Launched Effect") }
            )
        }
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Button(onClick = { isSnackbarVisible = !isSnackbarVisible }) {
                Text(text =
                    if (isSnackbarVisible) "Hide Snackbar"
                    else "Show Snackbar"
                )
            }
        }
    }
}