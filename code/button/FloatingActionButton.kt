@Composable
private fun FloatingActionButton() {

    FloatingActionButton()
        onClick = { /*your code*/ }
    ) {
        Icon(
            Icons.Rounded.Add,
            contentDescription = "Floating ActionButton"
        )
    }

/* Or you can use an Extended Floating Action Button */

    @Composable
    private fun FloatingActionButton() {

        ExtendedFloatingActionButton(
            text = { Text(text = "Extended FAB with Icon") },
            onClick = { /*your code*/ },
            icon = { Icon(Icons.Filled.Add, contentDescription = "Floating Action Button") }
        )
    }
