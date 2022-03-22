package de.check24.compose.demo.features.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme

class ComposableModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Modifier")
                            })
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            ModifierDemoScreen()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ModifierDemoScreen() {

    Column {

        PaddingDemo()
        MarginDemo()
        SizeDemo()
        ClickableDemo()
        ShadowDemo()
        BackgroundDemo()
    }
}

@Composable
fun PaddingDemo() {
    Text(
        text = "padding",
        modifier = Modifier.background(Color.Gray).padding(50.dp)
    )
}

@Composable
fun BackgroundDemo() {
    TODO("Not yet implemented")
}

@Composable
fun ShadowDemo() {
    TODO("Not yet implemented")
}

@Composable
fun ClickableDemo() {
    TODO("Not yet implemented")
}

@Composable
fun SizeDemo() {
    TODO("Not yet implemented")
}

@Composable
fun MarginDemo() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    DemoTheme {
        ModifierDemoScreen()
    }
}