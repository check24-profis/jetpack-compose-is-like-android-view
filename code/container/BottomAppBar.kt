@Composable
fun BottomAppBarExample() {

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
            BottomAppBarDetails(screens, currentScreen)
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButtonDetails()
        },
    ) {
        when (currentScreen.value) {
            BottomBarScreen.Favorite -> FavoriteScreen()
            BottomBarScreen.Download -> DownloadScreen()
        }
    }
}

@Composable
fun BottomAppBarDetails(
    screens: List<BottomBarScreen>,
    currentScreen: MutableState<BottomBarScreen>
) {
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
}

@Composable
fun FloatingActionButtonDetails() {
    FloatingActionButton(
        shape = CircleShape,
        onClick = { /* your code */ }
    ) {
        Icon(
            Icons.Filled.Add,
            "Floating Action Button"
        )
    }
}