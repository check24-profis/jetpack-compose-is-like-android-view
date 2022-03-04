Composable
fun Password() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier.requiredWidth(250.dp).wrapContentHeight(),
        maxLines = 1,
        label = {
            Text(text = "Your Label")
        },
        placeholder = {
            Text(text = "Your Placeholder/Hint")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}