package de.check24.compose.demo.features.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import de.check24.compose.demo.theme.DemoTheme
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
                    AlertDialogExample() {
                        lifecycleScope.launch {
                            finish()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AlertDialogExample(onExit: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { isVisible = true }
        ) {
            Text(text = "SHOW DIALOG")
        }
    }

    ShowDialog(isVisible) {
        onExit()
    }
}

@Composable
private fun ShowDialog(isVisible: Boolean, onClick: () -> Unit) {

    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onClick() },
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
                        ) {
                            onClick()
                        }
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
                        ) {
                            onClick()
                        }
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
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun AlertDialogExamplePreview() {
    DemoTheme {
        AlertDialogExample() { }
    }
}