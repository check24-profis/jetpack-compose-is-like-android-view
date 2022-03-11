@Composable
fun HorizontalScrollBox() {
    val scrollState = rememberScrollState()

    LazyRow(
        Modifier
            .fillMaxSize()
            .horizontalScroll(scrollState)
    ) {
        [...]
    }
}