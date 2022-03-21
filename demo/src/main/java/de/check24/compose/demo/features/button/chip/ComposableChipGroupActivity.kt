package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.R
import de.check24.compose.demo.theme.DemoTheme

class ComposableChipGroupActivity : ComponentActivity() {
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Chip Group")
                            }
                        )
                    },
                    content = {
                        ChipGroupExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun ChipGroupExample() {

    val list = listOf(
        "Chip One",
        "Chip Two",
        "Chip Three",
        "Chip Four",
        "Chip Five",
        "Chip Six",
        "Chip Seven",
        "Chip Eight",
        "Chip Nine",
        "Chip Ten"
    )

    val selectedChip = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            items(list) {

                val color by animateColorAsState(
                    if (selectedChip.value == it) {
                        colorResource(id = R.color.purple_200)
                    } else Color.LightGray
                )

                // through row we get a riddle effect over the Text with padding
                Row(
                    modifier = Modifier
                        .background(color)
                        .toggleable(
                            value = false,
                            onValueChange = { }
                        )
                        .clickable {
                            selectedChip.value = it
                        }
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(10.dp),
                    )
                }
                // through this statement there is no spacer after the last element
                if (it != list[list.size - 1])
                    Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ChipGroupPreview() {
    DemoTheme {
        ChipGroupExample()
    }
}