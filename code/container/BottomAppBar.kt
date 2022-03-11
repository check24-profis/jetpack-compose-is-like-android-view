@Composable
fun BottomAppBarExample() {

    val selectedItem = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                content = {
                    BottomNavigation(
                    ) {
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    Icons.Filled.Favorite,
                                    "favorite icon"
                                )
                            },
                            label = { Text(text = "Favorite") },
                            selected = selectedItem.value == "favorite",
                            onClick = {
                                selectedItem.value = "favorite"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            selected = false,
                            onClick = { },
                            icon = {},
                            enabled = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    Icons.Filled.Download,
                                    "download icon"
                                )
                            },
                            label = {
                                Text(
                                    text = "Download",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            selected = selectedItem.value == "download",
                            onClick = {
                                selectedItem.value = "download"
                            },
                            alwaysShowLabel = false
                        )
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {}
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Floating Action Button"
                )
            }
        },
        content = {}
    )
}