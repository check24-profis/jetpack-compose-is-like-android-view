@Composable
private fun StaggeredGrid() {
    LazyColumn {
        item {
            StaggeredVerticalGrid(
                maxColumnWidth = 155.dp,
                modifier = Modifier.padding(4.dp)
            ) {
                (1..100).forEach {
                    GridItem()
                }
            }
        }
    }
}

@Composable
private fun GridItem() {
    Card(
        modifier = Modifier
            .height((100..250).random().dp)
            .padding(5.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
        )
    }
}

@Composable
private fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    maxColumnWidth: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        check(constraints.hasBoundedWidth) {
            "Unbounded width not supported"
        }
        // get how many columns fit on screen
        val columns = ceil(constraints.maxWidth / maxColumnWidth.toPx()).toInt()

        // get how wide every column can be
        val columnWidth = constraints.maxWidth / columns
        val itemConstraints = constraints.copy(maxWidth = columnWidth)

        // track each column's height
        val colHeights = MutableList(columns) { 0 }
        val placeables = measurables.map { measurable ->
            val column = shortestColumn(colHeights)
            val placeable = measurable.measure(itemConstraints)
            colHeights[column] += placeable.height
            placeable
        }

        val height = colHeights.maxOrNull()
            ?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            // save the y coordinate for each column
            val colY = MutableList(columns) { 0 }
            placeables.forEach { placeable ->
                val column = shortestColumn(colY)
                placeable.place(
                    // calculate the x coordinate of each element
                    x = columnWidth * column,
                    y = colY[column]
                )
                colY[column] += placeable.height
            }
        }
    }
}

private fun shortestColumn(colHeights: MutableList<Int>): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}