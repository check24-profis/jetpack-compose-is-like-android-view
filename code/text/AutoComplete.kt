/* This is NOT an official implementation!
* Look if there is an official implementaion already*/

@Composable
private fun AutoCompleteExample() {

    val countriesList = listOf(
        "Germany",
        "Spain",
        "France",
    )

    val dropDownOptions = remember { mutableStateOf(listOf("")) }
    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }
    val dropDownExpanded = remember { mutableStateOf(false) }

    fun onDropdownDismissRequest() {
        dropDownExpanded.value = false
    }

    fun onValueChanged(value: TextFieldValue) {
        dropDownExpanded.value = true
        textFieldValue.value = value
        dropDownOptions.value =
            countriesList.filter { it.startsWith(value.text) && it != value.text }.take(3)
    }

    TextFieldWithDropdown(
        value = textFieldValue.value,
        setValue = ::onValueChanged,
        onDismissRequest = ::onDropdownDismissRequest,
        dropDownExpanded = dropDownExpanded.value,
        list = dropDownOptions.value,
    )
}

@Composable
private fun TextFieldWithDropdown(
    value: TextFieldValue,
    setValue: (TextFieldValue) -> Unit,
    onDismissRequest: () -> Unit,
    dropDownExpanded: Boolean,
    list: List<String>
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .onFocusChanged { focusState ->
                if (!focusState.isFocused)
                    onDismissRequest()
            },
        value = value,
        onValueChange = setValue,
        label = { Text("Enter a country of Europe") },
        colors = TextFieldDefaults.outlinedTextFieldColors()
    )
    DropdownMenu(
        expanded = dropDownExpanded,
        properties = PopupProperties(
            focusable = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        onDismissRequest = onDismissRequest,
    ) {
        list.forEach { text ->
            DropdownMenuItem(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClickLabel = text,
                    null
                ) {
                    setValue(
                        TextFieldValue(
                            text,
                            TextRange(text.length)
                        )
                    )
                },
                onClick = {
                    setValue(
                        TextFieldValue(
                            text,
                            TextRange(text.length)
                        )
                    )
                }
            ) {
                Text(text = text)
            }
        }
    }
}