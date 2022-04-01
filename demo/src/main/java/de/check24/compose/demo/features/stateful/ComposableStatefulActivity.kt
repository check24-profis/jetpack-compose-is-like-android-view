package de.check24.compose.demo.features.stateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import de.check24.compose.demo.theme.DemoTheme

class ComposableStatefulActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "Stateful") })
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        StatefulExample()
                    }
                }
            }
        }
    }
}

// stateful composables tend to be less reusable and harder to test

@Composable
private fun StatefulExample() {
    // stateful means that the composable manages its own state
    // no states are handled in the parent object.
    MySwitch()
}

@Composable
private fun MySwitch() {
    // the state
    var isClicked by remember { mutableStateOf(false) }

    Switch(
        checked = isClicked,
        // the child manages its own state
        onCheckedChange = { isClicked = !isClicked}
    )
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun StatefulExamplePreview() {
    DemoTheme {
        StatefulExample()
    }
}