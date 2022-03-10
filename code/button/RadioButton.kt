@Composable
fun RadioButtonExample() {
    val observer = remember { mutableStateOf(false) }

    RadioButton(
        selected = observer.value,
        onClick = { observer.value = true }
    )

    Text(text = "I am a Radio Button")
}

