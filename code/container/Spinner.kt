@Composable
private fun SpinnerExample() {

    val itemList = listOf(
        "Berlin",
        "Hamburg",
        "Stuttgart",
        "München",
        "Düsseldorf",
        "Osnabrück"
    )
    Spinner(text = "Select a city!", itemList)
}

@Composable
private fun Spinner(
    text: String = "Select something!",
    list: List<String>,
    onClick: ((String) -> Unit)? = null
) {
    var shownText by remember { mutableStateOf(text) }
    var expanded by remember { mutableStateOf(false) }

    // The Row aligns text and icon
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = shownText, Modifier.clickable { expanded = !expanded })
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach { item ->

                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        shownText = item
                        onClick?.invoke(item)
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}