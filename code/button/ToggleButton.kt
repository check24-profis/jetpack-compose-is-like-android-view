/* this is a custom build toggle button because*/
/* there is no toggle button in compose right now */

@Composable
fun CustomToggleButton() {

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

