package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.R
import de.check24.compose.demo.compareItemList
import de.check24.compose.demo.theme.DemoTheme

class ComposableChipGroupActivity : ComponentActivity() {

    private val list = mutableListOf(
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
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "MultiSelection")
                            ChipGroupMultiSelectionExample(list)

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(20.dp)
                            )

                            Text(text = "SingleSelection")
                            ChipGroupSingleSelectionExample(list)


                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(20.dp)
                            )

                            Text(text = "FilterSelection")
                            FilterChipGroup()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ChipGroupMultiSelectionExample(list: List<String> = listOf("I'm a list")) {

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        items(list) {
            ActionChip(it)
        }
    }
}

@Composable
private fun ChipGroupSingleSelectionExample(list: List<String> = listOf("I'm a list")) {

    var selectedChip by remember { mutableStateOf("") }

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        items(list) { item ->

            ActionChipMultiSelection(selectedChip = selectedChip, currentItem = item) {
                selectedChip = item
            }
        }
    }
}

@Composable
private fun FilterChipGroup() {

    val currentList = remember {
        mutableStateListOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"
        )
    }

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        items(currentList) {
            InputChip(name = it, iconEnabled = false)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ChipGroupPreview() {
    DemoTheme {
        ChipGroupMultiSelectionExample()
    }
}