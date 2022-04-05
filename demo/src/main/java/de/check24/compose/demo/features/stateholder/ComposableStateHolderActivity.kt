package de.check24.compose.demo.features.stateholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200

class ComposableStateHolderActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "State Holder") })
                    }
                ) {
                    MyScreen()
                }
            }
        }
    }
}

class MyStateHolder() {
    // states
    var text by mutableStateOf("")
    var isClicked by mutableStateOf(false)

    // events
    fun onTextChanged(input: String) {
        text = input
    }

    fun onToggle(clicked: Boolean) {
        isClicked = clicked
    }
}

@Composable
fun rememberStateHolder(): MyStateHolder =
    remember { MyStateHolder() }

@Composable
fun MyScreen(state: MyStateHolder = rememberStateHolder()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.text,
            onValueChange = { state.onTextChanged(it) },
        )

        Switch(
            checked = state.isClicked,
            onCheckedChange = { state.onToggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (state.isClicked) Green200 else Blue200
                )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun StateHolderExamplePreview() {
    DemoTheme {
        MyScreen()
    }
}