@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridExample() {

    val colorList = listOf(
        Color.Red,
        Color.Black,
        Color(0xFFBB86FC),
        Color(0xFF3700B3)
    )

    Grid(columnCount = 2, rowCount = 3) {
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
fun Grid(
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
                it.place(positions[it]!!)
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
        var max = 0
        for (j in i until min(i + columnCount, heights.size)) {
            if (max < heights[j]) max = heights[j]
        }
        result.add(max)
    }

    return result
}