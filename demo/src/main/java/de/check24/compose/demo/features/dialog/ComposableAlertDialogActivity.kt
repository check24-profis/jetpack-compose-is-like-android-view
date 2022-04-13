package de.check24.compose.demo.features.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import de.check24.compose.demo.theme.DemoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ComposableAlertDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "AlertDialog") }
                        )
                    }
                ) {
                    AlertDialogExample()
                }
            }
        }

        lifecycleScope.launch {
            delay(2000)
            finish()
        }
    }
}

@Composable
private fun AlertDialogExample() {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(
                text = "Title",
                style = MaterialTheme.typography.h6
            )
        },
        confirmButton = {
            Text(
                text = "ACCEPT",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { }
            )
        },
        dismissButton = {
            Text(
                text = "DECLINE",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { }
            )
        },
        text = {
            Text(
                text = "Scias me hoc mane canem meum mulsisse. Numquam satus dies sine me calidum pug lac",
                style = MaterialTheme.typography.body1
            )
        }
    )
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun AlertDialogExamplePreview() {
    DemoTheme {
        AlertDialogExample()
    }
}