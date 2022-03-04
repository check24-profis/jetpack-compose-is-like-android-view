@Composable
fun PhoneNumber() {
    var text by remember { mutableStateOf(TextFieldValue("012345678900")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        maxLines = 1,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder/Hint") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
    )
}