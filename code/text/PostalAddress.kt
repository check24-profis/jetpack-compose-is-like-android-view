@Composable
fun PostalAddressExample() {

    var address by remember { mutableStateOf("") }

    TextField(
        value = address,
        onValueChange = { address = it },
    )
}