package de.check24.compose.demo.features.list.grid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Purple200
import de.check24.compose.demo.theme.Purple700
import kotlin.math.ceil
import kotlin.math.min

@Composable
internal fun FixedGridExample() {
    val colorList = listOf(
        Color.Red,
        Color.Black,
        Purple200,
        Purple700
    )

    FixedGrid(2) {

        (0..3).forEach {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(colorList[it % 4])
            )
        }
    }
}

@Composable
internal fun FixedGrid(
    columnCount: Int,
    content: @Composable () -> Unit
) {

    Layout(content = content) { measurables, constraints ->

        val rowCount: Int =
            ceil(measurables.size.toDouble() / columnCount.toDouble()).toInt()

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

        layout(
            width = layoutWidth,
            height = layoutHeight
        ) {
            placeables.forEachIndexed { index, placeable ->
                placeable.place(
                    x = xPositions[index % columnCount],
                    y = yPositions[index / columnCount]
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

@Preview(showBackground = true)
@Composable
private fun FixedGridExamplePreview() {
    DemoTheme {
        FixedGridExample()
    }
}