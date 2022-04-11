package de.check24.compose.demo.features.helperlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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

    var rotationRGB: Float by remember { mutableStateOf(0f) }
    val angleRGB: Float by animateFloatAsState(
        targetValue = rotationRGB,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
    )

    var rotationRG: Float by remember { mutableStateOf(0f) }
    val angleRG: Float by animateFloatAsState(
        targetValue = rotationRG,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
    )

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (buttonRotateRGB, buttonRotateRG, colorBoxes) = createRefs()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .constrainAs(colorBoxes) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .graphicsLayer {
                    rotationZ = angleRGB
                }
        ) {
            Column(
                modifier = Modifier.graphicsLayer {
                    rotationZ = angleRG
                }
            ) {
                ColorBox(color = Red200)
                ColorBox(color = Green200)
            }
            ColorBox(color = Blue200)
        }

        Button(
            onClick = { rotationRGB += 360f },
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 20.dp)
                .constrainAs(buttonRotateRGB) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttonRotateRG.top)
                }
        ) {
            Text(text = "Rotate 360°")
        }

        Button(
            onClick = { rotationRG += 360f },
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 20.dp)
                .constrainAs(buttonRotateRG) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = "Rotate Red and Green°")
        }
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