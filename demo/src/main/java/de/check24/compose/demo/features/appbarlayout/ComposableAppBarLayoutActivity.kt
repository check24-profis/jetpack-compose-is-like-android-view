package de.check24.compose.demo.features.appbarlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.theme.DemoTheme

class ComposableAppBarLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                AppBarExample()
            }
        }
    }
}

@Composable
private fun AppBarExample() {
    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = "App Bar Layout",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* your code */ }) {

                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }

            )
        },
        content = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun AppBarExamplePreview() {
    DemoTheme {
        AppBarExample()
    }
}