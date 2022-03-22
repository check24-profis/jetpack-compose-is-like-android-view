package de.check24.compose.demo.features.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme

class ComposableModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Modifier")
                            })
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            ModifierDemoScreen()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ModifierDemoScreen() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        MarginDemo()
        Spacer(modifier = Modifier.size(20.dp))
        SizeDemo()
        Spacer(modifier = Modifier.size(20.dp))
        ClickableDemo()
        Spacer(modifier = Modifier.size(20.dp))
//        ShadowDemo()
        Spacer(modifier = Modifier.size(20.dp))
//        BackgroundDemo()
    }
}

@Composable
private fun MarginDemo() {

    Card(backgroundColor = Color.Blue) {

        Text(
            text = "padding (red) and margin (blue)",
            modifier = Modifier
                .padding(
                    horizontal = 50.dp,
                    vertical = 20.dp
                ) // Margin
                .background(Color.Red)
                .padding(20.dp) // Padding
        )
    }
}

@Composable
private fun SizeDemo() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        Card(
            backgroundColor = Color.LightGray,
            modifier = Modifier.size(70.dp),

            ) {

            Text(
                text = "size: big"
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Card(
            backgroundColor = Color.LightGray,
            modifier = Modifier.size(50.dp)
        ) {

            Text(
                text = "size: small"
            )
        }
    }
}

@Composable
private fun ClickableDemo() {
    var count by remember { mutableStateOf(0) }
    Text(
        text = "Clicked ${count}x",
        modifier = Modifier
            .clickable {
                count++
            }
    )
}

@Composable
private fun ShadowDemo() {
    TODO("Not yet implemented")
}

@Composable
private fun BackgroundDemo() {
    TODO("Not yet implemented")
}


@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    DemoTheme {
        ModifierDemoScreen()
    }
}