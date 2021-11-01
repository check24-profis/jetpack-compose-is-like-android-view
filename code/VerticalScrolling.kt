@Composable
fun VerticalScrollBox() {
    val scrollState = rememberScrollState()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        [...]
    }
}