@Composable
fun WithoutSideEffect() {
    var timer by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp)
            .background(Green200),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$timer",
        )
    }

    Thread.sleep(1000)
    timer++
}

@Composable
fun WithSideEffect() {
    var timer by remember {
        mutableStateOf(0)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp)
            .background(Green200),
    ) {
        Text(
            text = "$timer",
        )
    }

    SideEffect {
        Thread.sleep(1000)
        timer++
    }
}