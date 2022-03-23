@Composable
fun ClickableDemo() {

    var count by remember { mutableStateOf(0) }

    Text(
        text = "Clicked ${count}x",
        modifier = Modifier
            .clickable {
                count++
            }
    )
}
