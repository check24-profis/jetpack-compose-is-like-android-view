package de.check24.compose.demo.features.list.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
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
import kotlin.math.min

class ComposableGridActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Grid")
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

    val colorList = listOf(
        Color.Red,
        Color.Black,
        Color(0xFFBB86FC),
        Color(0xFF3700B3)
    )

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

        // get maximum widths of elements in each column
        val widths = getWidths(columnCount, placeableWidths)
        // get maximum heights of elements in each row
        val heights = getHeights(columnCount, placeableHeights)

        val layoutWidth = widths.sum()
        val layoutHeight = heights.sum()

        val xPositions = List(columnCount) {
            var result = 0
            for (i in 0 until it) {
                result += widths[i]
            }
            result
        }

        val yPositions = List(rowCount) {
            var result = 0
            for (i in 0 until it) {
                result += heights[i]
            }
            result
        }

        val positions: MutableMap<Placeable, IntOffset> = mutableMapOf()

        placeables.forEachIndexed { index, placeable ->
            positions[placeable] = IntOffset(
                x = xPositions[index % columnCount],
                y = yPositions[index / columnCount]
            )
        }

        layout(
            width = layoutWidth,
            height = layoutHeight
        ) {
            placeables.forEach {
                it.place(
                    requireNotNull(
                        positions[it]
                    )
                )
            }
        }
    }
}

private fun getWidths(
    columnCount: Int,
    widths: List<Int>,
): List<Int> {

    val result = mutableListOf<Int>()

    for (i in 0 until columnCount) {

        // specifies the width of the column by the widest element
        var max = 0
        for (j in i until widths.size step columnCount) {
            if (max < widths[j]) max = widths[j]
        }
        result.add(max)

    }

    return result
}

private fun getHeights(
    columnCount: Int,
    heights: List<Int>,
): List<Int> {

    val result = mutableListOf<Int>()

    for (i in heights.indices step columnCount) {

        // specifies the height of the row by the highest element
        var max = 0
        for (j in i until min(i + columnCount, heights.size)) {
            if (max < heights[j]) max = heights[j]
        }
        result.add(max)

    }

    return result
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun GridExamplePreview() {
    DemoTheme {
        GridExample()
    }
}