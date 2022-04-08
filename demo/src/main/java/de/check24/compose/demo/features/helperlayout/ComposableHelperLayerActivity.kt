package de.check24.compose.demo.features.helperlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200
import de.check24.compose.demo.theme.Red200

class ComposableHelperLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Helper (Layer)") }
                        )
                    }
                ) {
                    HelperLayerExample()
                }
            }
        }
    }
}

@Composable
private fun HelperLayerExample() {

    val angle: Float by animateFloatAsState(targetValue = 360F,)

    Column(
        modifier = Modifier
            .wrapContentSize()
            .rotate(degrees = 360F),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        listOf(Red200, Green200, Blue200).forEach {
            ColorBox(color = it)
        }

    }
    Button(
        onClick = {},
        modifier = Modifier
            .wrapContentSize()
            .padding(20.dp)
    ) {
        Text(text = "Rotate 360°")
    }
}

@Composable
private fun ColorBox(color: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
    )
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun HelperLayoutExamplePreview() {
    DemoTheme {
        HelperLayerExample()
    }
}