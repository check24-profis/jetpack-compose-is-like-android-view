@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridExample() {

    val colorList = listOf(
        Color.Red,
        Color.Black,
        Color(0xFFBB86FC),
        Color(0xFF3700B3)
    )

    Box(Modifier.size(200.dp)) {

        LazyVerticalGrid(cells = GridCells.Fixed(2)) {

            (0..3).forEach {

                item {

                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(colorList[it])
                    )
                }
            }
        }
    }
}