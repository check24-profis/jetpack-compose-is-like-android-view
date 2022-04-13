@Composable
fun AlertDialogExample() {
    var isVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { isVisible = true }
        ) {
            Text(text = "SHOW DIALOG")
        }
    }

    ShowDialog(isVisible) {
        isVisible = !isVisible
    }
}

@Composable
fun ShowDialog(isVisible: Boolean, onClick: () -> Unit) {

    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onClick() },
            title = {
                Text(
                    text = "Title",
                    style = MaterialTheme.typography.h6
                )
            },
            confirmButton = {
                Text(
                    text = "ACCEPT",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onClick()
                        }
                )
            },
            dismissButton = {
                Text(
                    text = "DECLINE",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onClick()
                        }
                )
            },
            text = {
                Text(
                    text = "Scias me hoc mane canem meum mulsisse. Numquam satus dies sine me calidum pug lac",
                    style = MaterialTheme.typography.body1
                )
            }
        )
    }
}