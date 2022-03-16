@Composable
fun MultilineText() {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        label = {
            Text(text = "Label")
        },
        placeholder = {
            Text(text = "Your Placeholder/Hint")
        }
    )
}