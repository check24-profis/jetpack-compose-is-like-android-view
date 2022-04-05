package de.check24.compose.demo.features.stateless

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

class ComposableStatelessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "Stateless") })
                    }
                ) {
                    StatelessExample()
                }
            }
        }
    }
}

@Composable
private fun StatelessExample() {

    // the parent manages the state of the child
    var isClicked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MySwitch(isClicked = isClicked) {
            // the parent, in this case th StatelessExample manages the state of MySwitch through an event
            isClicked = !isClicked
        }
    }
}

@Composable
private fun MySwitch(isClicked: Boolean, onToggle: () -> Unit) {
    // the child gives back the event to parent via lambda expression
    Switch(
        checked = isClicked,
        onCheckedChange = { onToggle() }
    )
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(
                if (isClicked) Green200 else Blue200
            )
    )
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun StatelessExamplePreview() {
    DemoTheme {
        StatelessExample()
    }
}