package de.check24.demo.features.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import de.check24.demo.ui.theme.DemoTheme

class ComposableFloatingActionButton : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Floating Action Button")
                            }
                        )
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            FloatingActionButtonExample()
                        }
                    })
            }
        }
    }
}

@Composable
private fun FloatingActionButtonExample() {


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, "Floating Action Button")
            }
        }) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (iconFAB, RectangleFAB, ExtendedFABWithIcon, ExtendedFAB, customFAB) = createRefs()

            FloatingActionButton(
                modifier = Modifier.constrainAs(iconFAB) {
                    top.linkTo(parent.top, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                onClick = { /*your code*/ }
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "Floating ActionButton"
                )
            }

            FloatingActionButton(
                modifier = Modifier.constrainAs(RectangleFAB) {
                    top.linkTo(iconFAB.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                onClick = { /*your code*/ },
                shape = RectangleShape
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "Floating ActionButton"
                )
            }

            ExtendedFloatingActionButton(
                modifier = Modifier.constrainAs(ExtendedFABWithIcon) {
                    top.linkTo(RectangleFAB.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                text = { Text(text = "Extended FAB with Icon") },
                onClick = { /*your code*/ },
                icon = { Icon(Icons.Filled.Add, contentDescription = "Floating Action Button") }
            )

            ExtendedFloatingActionButton(
                modifier = Modifier.constrainAs(ExtendedFAB) {
                    top.linkTo(ExtendedFABWithIcon.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                text = { Text(text = "Extended FAB") },
                onClick = { /*your code*/ }
            )

            FloatingActionButton(
                modifier = Modifier.constrainAs(customFAB) {
                    top.linkTo(ExtendedFAB.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                onClick = { /*your code*/ },
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            ) {
                Text(text = "Custom FAB")
            }
        }


    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun FloatingActionButtonPreview() {
    DemoTheme {
        FloatingActionButtonExample()
    }
}
