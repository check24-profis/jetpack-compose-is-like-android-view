package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Orange200
import de.check24.compose.demo.theme.Red200
import de.check24.compose.demo.theme.Teal200

class ComposableVerticalLinearLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("LinearLayout Vertical")
                            }
                        )
                    }
                ) {
                    VerticalLinearLayoutExample()
                }
            }
        }
    }
}

@Composable
private fun VerticalLinearLayoutExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Text(
            text = "TextView One",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(vertical = 20.dp)
                .background(Orange200)
                .padding(10.dp)
        )
        Text(
            text = "TextView Two",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(vertical = 20.dp)
                .background(Red200)
                .padding(10.dp)
        )
        Text(
            text = "TextView Three",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(vertical = 20.dp)
                .background(Blue200)
                .padding(10.dp)
        )
        Text(
            text = "TextView Four",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(vertical = 20.dp)
                .background(Teal200)
                .padding(10.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun VerticalLinearLayoutExamplePreview() {
    DemoTheme {
        VerticalLinearLayoutExample()
    }
}