@Composable
fun RadioButtonExample() {
    val observer = remember { mutableStateOf("") }

    RadioButton(
        selected = observer.value == "clicked",
        onClick = { observer.value = "clicked" }
    )

    Text(text = "I am a Radio Button")
}

