@Composable
private fun BottomAppBarExample() {

    val navController = rememberNavController()

    val screens = listOf(
        BottomBarScreen.Favorite,
        BottomBarScreen.Download
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

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
                BottomNavigation() {
                    screens.forEach { screen ->
                        BottomNavigationItem(
                            label = { Text(text = screen.title) },
                            icon = {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = "Navigation Icon"
                                )
                            },
                            selected = currentDestination?.route == screen.route,
                            onClick = { navController.navigate(screen.route) },
                            alwaysShowLabel = false
                        )
                    }
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
        BottomNavGraph(navController = navController)
    }
}