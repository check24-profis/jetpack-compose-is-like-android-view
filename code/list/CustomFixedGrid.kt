@Composable
fun FixedGridExample() {
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
fun FixedGrid(
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

fun getWidths(
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

fun getHeights(
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