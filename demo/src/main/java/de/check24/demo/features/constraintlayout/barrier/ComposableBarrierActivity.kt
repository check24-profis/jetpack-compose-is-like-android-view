package de.check24.demo.features.constraintlayout.barrier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import de.check24.demo.ui.theme.DemoTheme

class ComposableBarrierActivity : ComponentActivity() {

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
                                    Text(text = "Constraint Layout (Barrier)")
                                })
                        }, content = {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                ConstraintLayoutBarrier()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutBarrier() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (text1, text2, button) = createRefs()

        Text(
            text = "text1",
            modifier = Modifier
                .constrainAs(text1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .height(200.dp)
                .wrapContentWidth()
        )

        Text(
            text = "text2",
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .wrapContentHeight()
                .wrapContentWidth()
        )

        val barrier = createBottomBarrier(text1, text2)

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(barrier)
                start.linkTo(parent.start)
            }
        ) {
            Text("Button")
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ConstraintLayoutBarrierPreview() {
    DemoTheme {
        ConstraintLayoutBarrier()
    }
}