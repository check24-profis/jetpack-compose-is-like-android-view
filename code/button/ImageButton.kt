@Composable
private fun ImageButton() {
    IconButton(
        onClick = { [...] },
    ) {
        Image(
            painter = painterResource(id = R.drawable.c24logo),
            contentDescription = "Image of Button",
            modifier = Modifier.size(40.dp)
        )
    }
}