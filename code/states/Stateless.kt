@Composable
fun StatelessExample() {

    // the parent manages the state of the child
    var isClicked by remember { mutableStateOf(false) }

    MySwitch(isClicked = isClicked) {
        // the parent, in this case th StatelessExample manages the state of MySwitch through an event of the child
        isClicked = !isClicked
    }
}

@Composable
fun MySwitch(isClicked: Boolean, onToggle: () -> Unit) {
    // the child gives back an event to parent via lambda expression,
    // so it can handle the state properly
    Switch(
        checked = isClicked,
        onCheckedChange = { onToggle() }
    )
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(
                if (isClicked) Green200 else Blue200
            )
    )
}