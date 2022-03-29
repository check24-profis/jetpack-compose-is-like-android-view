package de.check24.compose.demo.features.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.theme.DemoTheme


class ComposableThemeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExampleThemeDemo()
        }
    }
}

@Composable
private fun ExampleTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = exampleColors,
        typography = exampleTypography,
        shapes = exampleShapes,
        content = content
    )
}

@Composable
private fun ExampleThemeDemo() {

    ExampleTheme {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Text View",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        )
                    }
                )
            }, content = {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.padding(50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(text = "h1", style = MaterialTheme.typography.h1)
                        Text(text = "h2", style = MaterialTheme.typography.h1)
                        Text(text = "h3", style = MaterialTheme.typography.h1)
                        Text(text = "h4", style = MaterialTheme.typography.h1)
                        Text(text = "h5", style = MaterialTheme.typography.h1)
                        Text(text = "h6", style = MaterialTheme.typography.h1)
                        Text(text = "s1", style = MaterialTheme.typography.subtitle1)
                        Text(text = "s2", style = MaterialTheme.typography.subtitle2)
                        Text(text = "b1", style = MaterialTheme.typography.body1)
                        Text(text = "b2", style = MaterialTheme.typography.body2)

                        Button(onClick = {}, shape = MaterialTheme.shapes.small) {
                            Text(text = "button", style = MaterialTheme.typography.button)
                        }

                        Text(text = "caption", style = MaterialTheme.typography.caption)
                        Text(text = "overline", style = MaterialTheme.typography.overline)
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ExampleThemeDemoPreview() {
    DemoTheme {
        ExampleThemeDemo()
    }
}