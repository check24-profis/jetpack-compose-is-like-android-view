package de.check24.compose.demo.features.bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.theme.DemoTheme

class ComposableToolbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                ToolbarExample()
            }
        }
    }
}

@Composable
private fun ToolbarExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Toolbar")}
            ) 
        }
    ) {
        
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun ToolbarPreview() {
    DemoTheme {
        ToolbarExample()
    }
}