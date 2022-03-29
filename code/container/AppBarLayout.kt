@Composable
fun AppBarExample() {
    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = "App Bar Layout",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* your code */ }) {

                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }

            )
        },
        content = { [...] }
    )
}