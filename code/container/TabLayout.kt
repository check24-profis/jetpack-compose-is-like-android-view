@Composable
fun TabLayoutExample() {
    val selectedTabIndex = remember { mutableStateOf(0) }

    val tabTexts = listOf("A", "B", "C")

    TabRow(
        selectedTabIndex = selectedTabIndex.value,
        backgroundColor = Color.White
    ) {
        tabTexts.forEachIndexed { index, text ->
            Tab(
                selected = index == selectedTabIndex.value,
                modifier = Modifier.size(50.dp),
                onClick = {
                    selectedTabIndex.value = index
                }
            ) {
                Text(text = text)
            }
        }
    }
}