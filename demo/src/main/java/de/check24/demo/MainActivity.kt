package de.check24.demo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices.NEXUS_6
import androidx.compose.ui.tooling.preview.Preview
import de.check24.demo.extensions.findActivity
import de.check24.demo.features.text.TextActivity
import de.check24.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Menu()
                }
            }
        }
    }
}

@Composable
private fun Menu() {

    val activity = LocalContext.current.findActivity() ?: return

    Column {

        Row {
            Text(text = "Text", modifier = Modifier
                .clickable {
                    activity.startActivity(Intent(activity, TextActivity::class.java))
                }
            )
        }

        Row {
            Text(text = "Password", modifier = Modifier
                .clickable {
                    activity.startActivity(Intent(activity, TextActivity::class.java))
                }
            )
        }
    }

}

@Preview(showBackground = true, device = NEXUS_6, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    DemoTheme {
        Menu()
    }
}
