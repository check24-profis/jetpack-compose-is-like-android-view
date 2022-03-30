package de.check24.compose.demo.features.tablayout

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

class ComposableTabItemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "TabItem")
                            }
                        )
                    },
                    content = {
                        TabItemExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun TabItemExample() {

}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun TanItemExamplePreview() {
    DemoTheme {
        TabItemExample()
    }
}