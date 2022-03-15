@Composable
fun BottomAppBarExample() {

    val screens = listOf(
        BottomBarScreen.Favorite,
        BottomBarScreen.Download
    )

    val currentItem = remember { mutableStateOf<BottomBarScreen?>(null) }

    Scaffold(
        content = {  },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(cutoutShape = CircleShape) {
                screens.forEach { screen ->
                    BottomNavigationItem(
                        label = { Text(text = screen.title) },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = "Navigation Icon"
                            )
                        },
                        selected = screen == currentItem.value,
                        onClick = {
                            currentItem.value = screen
                        },
                        alwaysShowLabel = false
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { /* your code */ }
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Floating Action Button"
                )
            }
        },
    )
}