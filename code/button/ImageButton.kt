@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImageButton() {
    IconButton(
        onClick = { [...] },
        modifier = Modifier.size(240.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.c24logo),
            contentDescription = "Image of Button",
            modifier = Modifier.size(80.dp)
        )
    }
}