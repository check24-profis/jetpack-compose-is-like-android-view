package de.check24.demo.features.constraintlayout.guideline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import de.check24.demo.ui.theme.DemoTheme

class ComposableVerticalGuidelineActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Guideline Vertical")
                                })
                        }, content = {
                            ConstraintLayoutGuidelineVertical()
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ConstraintLayoutGuidelineVertical() {
    ConstraintLayout {

        val (button) = createRefs()
        val guideline = createGuidelineFromStart(100.dp)

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(guideline)
            }
        ) {
            Text("Button")
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ConstraintLayoutVerticalGuidelinePreview() {
    DemoTheme {
        ConstraintLayoutGuidelineVertical()
    }
}

