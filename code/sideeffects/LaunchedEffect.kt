@Composable
fun LaunchedEffectDemo() {
    var showSnackbar by remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    if (showSnackbar) {

        //LaunchedEffect Safely executes suspends funs
        LaunchedEffect(scaffoldState.snackbarHostState) {

            //showSnackbar is a suspend fun
            scaffoldState.snackbarHostState.showSnackbar(
                message = "this is a snackbar",
                actionLabel = "hide"
            )

            showSnackbar = scaffoldState.snackbarHostState.currentSnackbarData != null
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            TopAppBar(
                title = { Text(text = "Launched Effect") }
            )
        }
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Button(onClick = { showSnackbar = !showSnackbar }) {
                Text(text =
                    if (showSnackbar) "Hide Snackbar"
                    else "Show Snackbar"
                )
            }
        }
    }
}