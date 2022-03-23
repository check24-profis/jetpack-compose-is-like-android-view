@Composable
fun SizeDemo() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        Card(
            backgroundColor = Color.LightGray,
            modifier = Modifier.size(70.dp),

            ) {

            Text(
                text = "size: big"
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Card(
            backgroundColor = Color.LightGray,
            modifier = Modifier.size(50.dp)
        ) {

            Text(
                text = "size: small"
            )
        }
    }
}