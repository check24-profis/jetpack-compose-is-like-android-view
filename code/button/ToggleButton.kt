/* right now there is no toggle button in compose */

@Composable
private fun ToggleButtonExample() {

    val isToggleButtonChecked = remember {
        mutableStateOf(false)
    }

    IconToggleButton(
        modifier = Modifier.wrapContentSize(),
        checked = isToggleButtonChecked.value,
        onCheckedChange = { isToggleButtonChecked.value = !isToggleButtonChecked.value },
    ) {
        val color by animateColorAsState(
            if (isToggleButtonChecked.value) {
                Color.Green
            } else Color.Red
        )
        Icon(
            Icons.Filled.Check,
            "ToggleButtinIcon",
            tint = color
        )
    }
}

/* here is a custom build toggle button */

@Composable
private fun CustomToggleButton() {

    val buttonClicked: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val buttonText: String
    val buttonTextColor: Color
    val buttonBackgroundColor: Color

    if (buttonClicked.value) {
        buttonText = "On"
        buttonTextColor = Color.Green
        buttonBackgroundColor = Color.LightGray
    } else {
        buttonText = "Off"
        buttonTextColor = Color.Red
        buttonBackgroundColor = Color.Gray
    }

    Button(
        onClick = { buttonClicked.value = !buttonClicked.value },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonBackgroundColor)
    ) {
        Text(text = buttonText, color = buttonTextColor)
    }
}

