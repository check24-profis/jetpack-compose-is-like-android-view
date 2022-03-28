package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Orange200
import de.check24.compose.demo.theme.Purple200

class ComposableConstraintLayoutPositioningActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "ConstraintLayout Positioning")
                            }
                        )
                    }
                ) {
                    ConstraintLayoutPositioningExample()
                }
            }
        }
    }
}

@Composable
private fun ConstraintLayoutPositioningExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (purple, orange, blue, green, leftView, middleView, rightView) = createRefs()
        val chainRef = createHorizontalChain(blue, green, chainStyle = ChainStyle.Packed)

        Text(
            textAlign = TextAlign.Center,
            text = "constraint to start, top and end of parent with a horizontal bias of 30/70",
            modifier = Modifier
                .padding(top = 80.dp)
                .width(150.dp)
                .background(Purple200)
                .padding(10.dp)
                .constrainAs(purple) {
                    linkTo(
                        parent.start,
                        parent.end,
                        bias = 0.3F
                    )
                }
        )

        // todo: circular doesn't work. I think the ConstrainedLayoutReference is the problem
        Text(
            textAlign = TextAlign.Center,
            text = "constraint via circle radius(110dp) and angle(135) to purple",
            modifier = Modifier
                .width(150.dp)
                .background(Orange200)
                .padding(10.dp)
                .constrainAs(orange) {
                    circular(ConstrainedLayoutReference(purple), angle = 0.5F, distance = 50.dp)
                }
        )
        
        Text(text = "")
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ConstraintLayoutPositioningPreview() {
    DemoTheme {
        ConstraintLayoutPositioningExample()
    }
}