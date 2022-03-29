@Composable
fun TabLayoutExample() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabTexts = listOf("A", "B", "C")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.White
    ) {
        tabTexts.forEachIndexed { index, text ->
            Tab(
                selected = index == selectedTabIndex,
                modifier = Modifier.size(50.dp),
                onClick = {
                    selectedTabIndex = index
                }
            ) {
                Text(text = text)
            }
        }
    }
}