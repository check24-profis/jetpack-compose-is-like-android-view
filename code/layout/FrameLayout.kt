@Composable
fun FrameLayoutExample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.c24logo),
            contentDescription = "Check24 Logo",
            modifier = Modifier.size(250.dp)
        )
    }
}