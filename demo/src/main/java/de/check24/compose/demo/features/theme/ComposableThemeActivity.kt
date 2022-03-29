package de.check24.compose.demo.features.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class ComposableThemeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExampleComposable()
        }
    }
}



@Composable
private fun ExampleTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = exampleColors,
        typography = exampleTypography,
        content = content
    )
}

@Composable
private fun ExampleComposable() {

    ExampleTheme {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Text View")
                    })
            }, content = {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Card {
                        Column {

                            Text(text = "this is some text")

                            Button(onClick = {}, modifier = Modifier.padding(100.dp)) {
                                Icon(Icons.Sharp.Menu, contentDescription = "theme demo button")
                            }
                        }
                    }
                }
            }
        )
    }
}