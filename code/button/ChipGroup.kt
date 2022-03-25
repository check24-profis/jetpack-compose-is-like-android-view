@Composable
fun ChipGroupSingleSelectionExample(list: List<String> = listOf("I'm a list")) {

    var selectedChip by remember { mutableStateOf("") }

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        items(list) {
            ActionChip(it)
        }
    }
}