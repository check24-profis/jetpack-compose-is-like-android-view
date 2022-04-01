// stateful composables tend to be less reusable and harder to test

@Composable
private fun StatefulExample() {
    // stateful means that the composable manages its own state
    // no states are handled in the parent object.
    MySwitch()
}

@Composable
private fun MySwitch() {
    // the state
    var isClicked by remember { mutableStateOf(false) }

    Switch(
        checked = isClicked,
        // the child manages its own state
        onCheckedChange = { isClicked = !isClicked}
    )
}