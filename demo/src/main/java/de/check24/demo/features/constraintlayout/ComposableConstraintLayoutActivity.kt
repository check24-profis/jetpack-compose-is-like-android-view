package de.check24.demo.features.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


import de.check24.demo.ui.theme.DemoTheme

class ComposableConstraintLayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Constraint Layout")
                            })
                    }, content = {
                        ConstraintLayoutExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            //just for better looks
            .padding(10.dp)
    ) {
        val (text1, text2, text3, text4, text5) = createRefs()

        Text(
            text = "TopLeft",
            modifier = Modifier.constrainAs(text1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = "TopRight",
            modifier = Modifier.constrainAs(text2) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "BottomLeft",
            modifier = Modifier.constrainAs(text3) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = "BottomRight",
            modifier = Modifier.constrainAs(text4) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Center",
            modifier = Modifier.constrainAs(text5) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ConstraintLayoutBarrierPreview() {
    DemoTheme {
        ConstraintLayoutExample()
    }
}