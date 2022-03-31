@Composable
fun BottomAppBarExample() {

    val screens = listOf(
        BottomBarScreen.Favorite,
        BottomBarScreen.Download
    )

    var currentScreen by remember { mutableStateOf<BottomBarScreen>(BottomBarScreen.Favorite) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBarDetails(screens, currentScreen) {
                    screen ->
                currentScreen = screen
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButtonDetails()
        },
    ) {
        when (currentScreen) {
            BottomBarScreen.Favorite -> FavoriteScreen()
            BottomBarScreen.Download -> DownloadScreen()
        }
    }
}

@Composable
private fun BottomAppBarDetails(
    screens: List<BottomBarScreen>,
    currentScreen: BottomBarScreen,
    onClick : (BottomBarScreen) -> Unit
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
                selected = screen == currentScreen,
                onClick = {
                    onClick(screen)
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun FloatingActionButtonDetails() {
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