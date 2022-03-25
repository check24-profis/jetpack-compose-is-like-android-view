/* At the time of the implementation there were no official implementation!
* Look if there is an official implementaion already*/

@Composable
fun ChipExample(
    name: String = "Action Chip",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) colorResource(id = R.color.purple_100) else colorResource(id = R.color.gray_300),
    ) {
        // through row we get a ripple effect over the Text with padding
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                color = if (isSelected) colorResource(id = R.color.purple_500) else colorResource(id = R.color.gray_700),
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}