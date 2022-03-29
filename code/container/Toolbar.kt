@Composable
fun ToolbarExample() {
    Scaffold(
        topBar = {
            TopAppBarDetails()
        }
    ) { }
}

@Composable
private fun TopAppBarDetails() {

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var clickedItemText by remember { mutableStateOf("") }

    TopAppBar(
        title = { Text(text = "Toolbar") },
        navigationIcon = {
            IconButton(onClick = { context.findActivity()?.onBackPressed() }) {
                Icon(Icons.Default.ArrowBack, "Back Button")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Search, "Search")
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.MoreVert, "Options")
            }
            OptionDropdownMenu(expanded, onDismissMenu = { onDismissMenu: Boolean ->
                expanded = onDismissMenu
            }) {

            }
        }
    )
}

@Composable
private fun OptionDropdownMenu(
    expanded: Boolean,
    list: List<String> = listOf("First Option", "Second Option", "Third Option"),
    onDismissMenu: ((Boolean) -> Unit)? = null,
    onClickItem: ((String) -> Unit)? = null
) {

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { onDismissMenu?.invoke(false) },
    ) {
        list.forEach { item ->

            DropdownMenuItem(
                onClick = {
                    onClickItem?.invoke(item)
                    onDismissMenu?.invoke(false)
                }
            ) {
                Text(text = item)
            }
        }
    }
}