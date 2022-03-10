@Composable
fun RadioButtonExample() {
    val observer = remember { mutableStateOf(false) }

    RadioButton(
        selected = observer.value,
        onClick = { observer.value = !observer.value }
    )

    Text(
        text = "I am a Radio Button",
        modifier = Modifier
            .clickable {
                observer.value = !observer.value
            }
    )
}

