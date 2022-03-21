@Composable
fun CardExample() {

    Card(
        elevation = 10.dp,
        shape = CircleShape
    ) {
        Text(
            text = "Card with elevation and circleShape",
            modifier = Modifier.padding(15.dp)
        )
    }

    Card(
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = "Card with rounded corners and no elevation",
            modifier = Modifier.padding(15.dp)
        )
    }

    Card(
        elevation = 10.dp,
        backgroundColor = Color.LightGray
    ) {
        Text(
            text = "Card with color and elevation",
            modifier = Modifier.padding(15.dp)
        )
    }

    Card(
        elevation = 10.dp,
        border = BorderStroke(1.dp, Color.Green)
    ) {
        Text(
            text = "Card with a border",
            modifier = Modifier.padding(15.dp)
        )
    }

    Card(
        shape = RoundedCornerShape(
            topEnd = 15.dp,
            topStart = 0.dp,
            bottomEnd = 0.dp,
            bottomStart = 15.dp
        )
    ) {
        Text(
            text = "Card with two rounded corners",
            modifier = Modifier.padding(15.dp)
        )
    }

    val shapes = Shapes(
        large = CutCornerShape(
            topStart = 16.dp,
            topEnd = 0.dp,
            bottomEnd = 16.dp,
            bottomStart = 0.dp
        )
    )
    MaterialTheme(shapes = shapes){
        Card(
            elevation = 10.dp,
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                text = "Card with cut corners",
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}