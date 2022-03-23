@Composable
fun ShadowDemo() {

    Card(
        modifier = Modifier
            .shadow(elevation = 20.dp)
    ) {
        Text(
            text = "shadow",
            modifier = Modifier.padding(10.dp)
        )
    }
}