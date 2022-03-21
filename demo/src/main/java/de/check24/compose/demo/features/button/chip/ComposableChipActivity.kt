package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme

class ComposableChipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Chip ") }
                        )
                    },
                    content = {
                        ChipExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun ChipExample() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // through row we get a riddle effect over the Text with padding
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .toggleable(
                    value = false,
                    onValueChange = { }
                )
        ) {
            Text(
                text = "I'm a chip",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ChipPreview() {
    DemoTheme {
        ChipExample()
    }
}