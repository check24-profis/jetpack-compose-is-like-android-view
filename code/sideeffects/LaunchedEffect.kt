@Composable
fun LaunchedEffectDemo() {
    var isSnackbarVisible by remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    if (isSnackbarVisible) {

        //LaunchedEffect Safely executes suspends funs
        LaunchedEffect(scaffoldState.snackbarHostState) {

            //showSnackbar is a suspend fun
            scaffoldState.snackbarHostState.showSnackbar(
                message = "this is a snackbar",
                actionLabel = "hide"
            )

            isSnackbarVisible = scaffoldState.snackbarHostState.currentSnackbarData != null
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

            Button(onClick = { isSnackbarVisible = !isSnackbarVisible }) {
                Text(text =
                if (isSnackbarVisible) "Hide Snackbar"
                else "Show Snackbar"
                )
            }
        }
    }
}