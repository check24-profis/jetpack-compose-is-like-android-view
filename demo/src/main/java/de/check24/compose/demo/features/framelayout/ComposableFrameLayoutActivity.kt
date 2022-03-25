package de.check24.compose.demo.features.framelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.R
import de.check24.compose.demo.theme.DemoTheme

class ComposableFrameLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Frame Layout")
                            })
                    }, content = {
                        FrameLayoutExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun FrameLayoutExample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.c24logo),
            contentDescription = "Check24 Logo",
            modifier = Modifier.size(250.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun FrameLayoutExamplePreview() {
    DemoTheme {
        FrameLayoutExample()
    }
}