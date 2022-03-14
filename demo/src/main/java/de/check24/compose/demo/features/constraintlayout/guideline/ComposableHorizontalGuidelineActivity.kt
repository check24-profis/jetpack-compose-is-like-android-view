package de.check24.compose.demo.features.constraintlayout.guideline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import de.check24.compose.demo.theme.DemoTheme

class ComposableHorizontalGuidelineActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Guideline Horizontal")
                            })
                    }, content = {
                        ConstraintLayoutGuidelineHorizontal()
                    }
                )
            }
        }
    }
}

@Composable
private fun ConstraintLayoutGuidelineHorizontal() {
    ConstraintLayout {

        val (button) = createRefs()
        val guideline = createGuidelineFromTop(100.dp)

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(guideline)
            }
        ) {
            Text("Button")
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ConstraintLayoutHorizontalGuidelinePreview() {
    DemoTheme {
        ConstraintLayoutGuidelineHorizontal()
    }
}

