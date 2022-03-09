@Composable
private fun FloatingActionButton() {

    androidx.compose.material.FloatingActionButton(
        onClick = { /* your code*/ }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_date_range),
            contentDescription = "Floating Action Button",
            tint = androidx.compose.ui.graphics.Color.Black
        )
    }
}