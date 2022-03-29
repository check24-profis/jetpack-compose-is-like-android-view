Column(
    modifier = Modifier
    .fillMaxSize()
    .padding(50.dp)
) {
    Text(
        text = "TextView One",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .background(Orange200)
            .padding(10.dp)
    )

    [...]

}