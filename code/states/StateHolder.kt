class MyStateHolder() {
    // states
    var text by mutableStateOf("")
    var isClicked by mutableStateOf(false)

    // events
    fun onTextChanged(input: String) {
        text = input
    }

    fun onToggle(clicked: Boolean) {
        isClicked = clicked
    }
}

// Through this implementation, the lifecycle corresponds to the composable that implemented it
@Composable
fun rememberStateHolder(): MyStateHolder =
    remember { MyStateHolder() }

@Composable
fun MyScreen(state: MyStateHolder = rememberStateHolder()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.text,
            onValueChange = { state.onTextChanged(it) },
        )

        Switch(
            checked = state.isClicked,
            onCheckedChange = { state.onToggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (state.isClicked) Green200 else Blue200
                )
        )
    }
}