package de.check24.compose.demo.features.list.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme

class ComposableGridActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Modifier")
                            })
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            GridExample()
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun GridExample() {

    val colorList = listOf(Color.Red, Color.Black, Color(0xFFBB86FC), Color(0xFF3700B3))

    Grid(columnCount = 2, rowCount = 2) {
        (0..3).forEach {
            Card(
                modifier = Modifier.size(100.dp),
                backgroundColor = colorList[it],
                content = {}
            )
        }
    }
}

@Composable
private fun Grid(
    columnCount: Int,
    rowCount: Int,
    content: @Composable () -> Unit
) {
    Layout(content = content) { measurables, constraints ->

        val placeables = measurables.map { measurable ->
            measurable.measure(constraints = constraints)
        }

        val placeableWidths = placeables.map { it.width }
        val placeableHeights = placeables.map { it.height }

        val widths = getWidths(columnCount, placeableWidths)
        val heights = getHeights(rowCount, placeableHeights)

        val xPositions = List(columnCount) {

            var result = 0

            for (i in 0..it) {
                result += widths[i]
            }

            result
        }

        val yPositions = List(rowCount) {

            var result = 0

            for (i in 0..it) {
                result += heights[i]
            }

            result
        }

        val positions: MutableMap<Placeable, IntOffset> = mutableMapOf()

        placeables.forEachIndexed { index, placeable ->
            positions[placeable] = IntOffset(
                xPositions[index % columnCount],
                yPositions[index / rowCount]
            )
        }

        layout(
            width = widths.sum(),
            height = heights.sum()
        ) {
            placeables.forEach {
                it.place(positions[it]!!)
            }
        }
    }
}

private fun getWidths(
    columnCount: Int,
    widths: List<Int>,
): List<Int> {

    val result = MutableList(columnCount) { 0 }

    for (i in 0 until columnCount) {

        var max = 0

        for (j in widths.indices step columnCount) {

            if (max < widths[j]) max = widths[j]
        }

        result[i] = max
    }

    return result
}

private fun getHeights(
    rowCount: Int,
    heights: List<Int>,
): List<Int> {

    val result = MutableList(rowCount) { 0 }

    (0..heights.size-1 step rowCount).forEachIndexed { index, i ->

        var max = 0

        for (j in 0..rowCount-1) {

            if (max < heights[j]) max = heights[j]
        }

        result[index] = max
    }

    return result
}

@Composable
private fun GridExample2() {
    Column {
        Row {

            Card(
                modifier = Modifier.size(100.dp),
                backgroundColor = Color.Red,
                content = {}
            )
            Card(
                modifier = Modifier.size(100.dp),
                backgroundColor = Color.Black,
                content = {}
            )
        }

        Row {

            Card(
                modifier = Modifier.size(100.dp),
                backgroundColor = Color(0xFFBB86FC),
                content = {}
            )

            Card(
                modifier = Modifier.size(100.dp),
                backgroundColor = Color(0xFF3700B3),
                content = {}
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    DemoTheme {
        GridExample2()
    }
}