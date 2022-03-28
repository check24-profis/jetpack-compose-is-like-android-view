package de.check24.compose.demo.features.bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.extensions.findActivity
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
            TopAppBarDetails()
        }
    ) { }
}

@Composable
private fun TopAppBarDetails() {

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Toolbar") },
        navigationIcon = {
            IconButton(onClick = { context.findActivity()?.onBackPressed() }) {
                Icon(Icons.Default.ArrowBack, "Back Button")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Search, "Search")
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.MoreVert, "Options")
            }
            OptionDropdownMenu(expanded) {
                onDismiss: Boolean -> expanded = onDismiss
            }
        }
    )
}

@Composable
private fun OptionDropdownMenu(expanded: Boolean, onDismiss: (Boolean) -> Unit) {

    val list = listOf("First Option", "Second Option", "Third Option")
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { onDismiss(false) },
    ) {
        list.forEach { item ->

            DropdownMenuItem(
                onClick = {
                    onDismiss(false)
                }
            ) {
                Text(text = item)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun ToolbarPreview() {
    DemoTheme {
        ToolbarExample()
    }
}