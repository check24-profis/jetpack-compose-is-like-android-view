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

    FloatingActionButton(
        modifier = Modifier.constrainAs(RectangleFAB) { },
        onClick = { /*your code*/ },
        shape = RectangleShape
    ) {
        Icon(
            Icons.Rounded.Add,
            contentDescription = "Floating ActionButton"
        )
    }
}