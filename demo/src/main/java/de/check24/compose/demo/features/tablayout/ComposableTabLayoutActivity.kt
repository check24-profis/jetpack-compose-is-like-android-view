package de.check24.compose.demo.features.tablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme

class ComposableTabLayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Tab Layout")
                            })
                    }, content = {
                        TabLayoutExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun TabLayoutExample() {
    val selectedTabIndex = remember { mutableStateOf(0) }

    val tabTexts = listOf("A", "B", "C")

    TabRow(
        selectedTabIndex = selectedTabIndex.value,
        backgroundColor = Color.White
    ) {
        tabTexts.forEachIndexed { index, text -> 
            Tab(
                selected = index == selectedTabIndex.value,
                modifier = Modifier.size(50.dp),
                onClick = {
                    selectedTabIndex.value = index
                }
            ) {
                Text(text = text)
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun SwitchPreview() {
    DemoTheme {
        TabLayoutExample()
    }
}