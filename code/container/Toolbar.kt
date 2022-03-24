@Composable
fun ToolbarExample() {
    Scaffold(
        topBar = {
            TopAppBarDetails()
        }
    ) { }
}

@Composable
fun TopAppBarDetails() {

    val context = LocalContext.current
    val expanded = remember { mutableStateOf(false) }

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
            IconButton(onClick = { expanded.value = !expanded.value }) {
                Icon(Icons.Default.MoreVert, "Options")
            }
            ShowOptionDropDown(expanded)
        }
    )
}

@Composable
fun ShowOptionDropDown(expanded: MutableState<Boolean>) {

    val list = listOf("First Option", "Second Option", "Third Option")
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
    ) {
        list.forEach { item ->

            DropdownMenuItem(
                onClick = {
                    expanded.value = false
                }
            ) {
                Text(text = item)
            }
        }
    }
}