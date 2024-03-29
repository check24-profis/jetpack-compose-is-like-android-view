package de.check24.compose.demo.features.spinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.theme.DemoTheme

class ComposableSpinnerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Spinner")
                            }
                        )
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            SpinnerExample()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun SpinnerExample() {

    val itemList = listOf(
        "Berlin",
        "Hamburg",
        "Stuttgart",
        "München",
        "Düsseldorf",
        "Osnabrück"
    )

    var text by remember { mutableStateOf("Select a city!") }
    var expanded by remember { mutableStateOf(false) }

    Spinner(
        text = text,
        expanded = expanded,
        list = itemList,
        onItemClick = {
            text = it
            expanded = false
        },
        onClick = {
            expanded = !expanded
        }
    )
}

@Composable
fun Spinner(
    text: String = "Select something!",
    expanded: Boolean = false,
    list: List<String>,
    onItemClick: ((String) -> Unit)? = null,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(text = text, )
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "ArrowDropDown",
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onClick
        ) {
            list.forEach { item ->

                DropdownMenuItem(
                    onClick = {
                        onItemClick?.invoke(item)
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun SpinnerPreview() {
    DemoTheme {
        SpinnerExample()
    }
}