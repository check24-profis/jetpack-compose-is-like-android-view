@Composable
private fun FloatingActionButton() {

    FloatingActionButton(
        onClick = { /* your code*/ }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_date_range),
            contentDescription = "Floating Action Button",
            tint = Color.Black
        )
    }
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
