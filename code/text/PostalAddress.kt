// There is no difference between the Postal Address and the normal TextInput
@Composable
fun PostalAddressExample() {

    var address by remember { mutableStateOf("") }

    TextField(
        value = address,
        onValueChange = { address = it },
    )
}