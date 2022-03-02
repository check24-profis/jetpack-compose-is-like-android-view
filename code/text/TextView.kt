@Composable
fun Label() {
    Text(
        text = "Hello World",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        style = TextStyle(background = Color(0xFF4a8fff))
    )
}