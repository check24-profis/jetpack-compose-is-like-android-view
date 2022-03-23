@Composable
fun MarginDemo() {

    Card(backgroundColor = Color.Blue) {

        Text(
            text = "padding (red) and margin (blue)",
            modifier = Modifier
                .padding(
                    horizontal = 50.dp,
                    vertical = 20.dp
                ) // Margin
                .background(Color.Red)
                .padding(20.dp) // Padding
        )
    }
}