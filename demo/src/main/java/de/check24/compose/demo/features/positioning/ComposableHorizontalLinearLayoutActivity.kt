package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Orange200
import de.check24.compose.demo.theme.Red200
import de.check24.compose.demo.theme.Teal200

class ComposableHorizontalLinearLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "LinearLayout Horizontal")
                            }
                        )
                    }
                ) {

                }
            }
        }
    }
}

@Composable
private fun HorizontalLinearLayoutExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(50.dp)
                .fillMaxHeight()
                .background(Orange200)
                .padding(10.dp)
        )
        Text(
            text = "",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(50.dp)
                .fillMaxHeight()
                .background(Red200)
                .padding(10.dp)
        )
        Text(
            text = "",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(50.dp)
                .fillMaxHeight()
                .background(Blue200)
                .padding(10.dp)
        )
        Text(
            text = "",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(50.dp)
                .fillMaxHeight()
                .background(Teal200)
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun HorizontalLinearLayoutExamplePreview() {
    DemoTheme {
        HorizontalLinearLayoutExample()
    }
}