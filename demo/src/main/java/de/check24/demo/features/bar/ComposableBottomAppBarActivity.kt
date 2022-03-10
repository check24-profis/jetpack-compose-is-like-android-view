package de.check24.demo.features.bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.demo.ui.theme.DemoTheme

class ComposableBottomAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                BottomAppBarExample()
            }
        }
    }
}

@Composable
private fun BottomAppBarExample() {

    val selectedItem = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    BottomNavigation(
                        modifier = Modifier,
                        elevation = 22.dp
                    ) {
                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Favorite, "")
                            },
                            label = { Text(text = "Favorite") },
                            selected = selectedItem.value == "favorite",
                            onClick = {
                                selectedItem.value = "favorite"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Save, "")
                            },
                            label = { Text(text = "Save") },
                            selected = selectedItem.value == "save",
                            onClick = {
                                selectedItem.value = "save"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Upload, "")
                            },


                            label = { Text(text = "Upload") },
                            selected = selectedItem.value == "upload",
                            onClick = {
                                selectedItem.value = "upload"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Download, "")
                            },
                            label = { Text(text = "Download") },
                            selected = selectedItem.value == "download",
                            onClick = {
                                selectedItem.value = "download"
                            },
                            alwaysShowLabel = false
                        )
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Floating Action Button"
                )
            }
        },
        content = {}
    )
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun BottomAppBarPreview() {
    DemoTheme {
        BottomAppBarPreview()
    }
}