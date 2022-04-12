/*
    the SideEffect is used when you only want to run code if the composable is successfully recomposed.
    After the recomposition the codeblock within the SideEffect gets executed.
*/

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

    /*
        through the Sleep, the timer gets changed when the composables recomposes itself.
        Therefore it does not call the recomposition.
    */
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

    /*
        Through SideEffect timer gets called after the composable got recomposed.
        So the composable gets recomposed and afterwards it increases timer.
        In this case we created a loop
    */
    SideEffect {
        Thread.sleep(1000)
        timer++
    }
}