@Composable
fun SpinnerExample() {

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
            expanded = !expanded
        }
    )
}

@Composable
fun Spinner(
    text: String = "Select something!",
    expanded: Boolean = false,
    list: List<String>,
    onItemClick: ((String) -> Unit)? = null,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(text = text, )
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "ArrowDropDown",
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onClick
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