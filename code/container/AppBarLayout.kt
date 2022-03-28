@Composable
fun AppBarExample() {
    TopAppBar {
        IconButton(onClick = { /* your code */ }) {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menu",
                modifier = Modifier.padding(10.dp)
            )
        }
        Text(
            text = "App Bar Layout",
            color = Color.White
        )
    }
}
