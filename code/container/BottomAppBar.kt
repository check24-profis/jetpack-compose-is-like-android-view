@Composable
private fun BottomAppBarExample() {

    val screens = listOf(
        BottomBarScreen.Favorite,
        BottomBarScreen.Download
    )

    val currentScreen = remember { mutableStateOf<BottomBarScreen>(BottomBarScreen.Favorite) }

    Scaffold(
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
                        selected = screen == currentScreen.value,
                        onClick = {
                            currentScreen.value = screen
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
    ) {
        when (currentScreen.value) {
            BottomBarScreen.Favorite -> FavoriteScreen()
            BottomBarScreen.Download -> DownloadScreen()
        }
    }
}