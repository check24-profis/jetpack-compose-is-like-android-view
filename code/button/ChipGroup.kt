@Composable
fun ChipGroupSingleSelectionExample(list: List<String> = listOf("I'm a list")) {

    var selectedChip by remember { mutableStateOf("") }

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        items(list) {

            Surface(
                modifier = Modifier.padding(4.dp),
                shape = CircleShape,
                color = if (selectedChip == it) {
                    colorResource(id = R.color.purple_100)
                } else colorResource(id = R.color.gray_300)
            ) {
                // through the Row we can align several items and have a nice ripple effect
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(32.dp)
                        .clickable { selectedChip = it }
                ) {
                    // here we can add our items, like texts and icons
                    Text(
                        text = it,
                        color = if (selectedChip == it) colorResource(id = R.color.purple_500) else colorResource(
                            id = R.color.gray_700
                        ),
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }
            }
        }
    }
}