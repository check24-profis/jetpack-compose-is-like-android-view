@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Email() {

    var text by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .requiredWidth(250.dp)
            .wrapContentHeight(),
        maxLines = 1,
        label = {
            Text(text = "Your Label")
        },
        placeholder = {
            Text(text = "Your Placeholder/Hint")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()} )
    )
}