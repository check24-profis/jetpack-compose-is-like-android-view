@Composable
fun TextInputExample() {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text("hint") }
    )
}