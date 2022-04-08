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

    var text by remember { mutableStateOf("Select a city!") }
    var expanded by remember { mutableStateOf(false) }

    Spinner(
        text = text,
        expanded = expanded,
        list = itemList,
        onItemClick = {
            text = it
            expanded = false
        },
        onClick = {
            expanded = it
        }
    )
}

@Composable
private fun Spinner(
    text: String = "Select something!",
    expanded: Boolean = false,
    list: List<String>,
    onItemClick: ((String) -> Unit)? = null,
    onClick: ((Boolean) -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, Modifier.clickable { onClick?.invoke(!expanded) })
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "",
            modifier = Modifier.clickable { onClick?.invoke(!expanded) }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onClick?.invoke(false) }
        ) {
            list.forEach { item ->

                DropdownMenuItem(
                    onClick = {
                        onItemClick?.invoke(item)
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}