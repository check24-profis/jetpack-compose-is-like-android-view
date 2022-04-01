@Composable
fun NumberDecimalExample() {

    var number by remember { mutableStateOf("") }

    TextField(
        value = number,
        onValueChange = { input ->
            number = validateInput(input)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

private fun validateInput(input: String): String {
    val filteredChars = input.filterIndexed { index, char ->
        char in "0123456789" ||
                (char == '.' && input.indexOf('.') == index)
    }
    return filteredChars
}