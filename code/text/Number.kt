@Composable
fun NumberExample() {

    var number by remember { mutableStateOf("") }

    TextField(
        value = number,
        onValueChange = { input ->
            number = input
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}