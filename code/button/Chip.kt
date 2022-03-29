/* At the time of the implementation there were no official implementation!
* Look if there is an official implementaion already*/

@Composable
fun ActionChip(
    name: String = "Action Chip",
    icon: ImageVector = Icons.Default.Circle,
    iconEnabled: Boolean = false,
    value : ((String) -> String)? = null
) {
    var isSelected by remember { mutableStateOf(false) }
    val modifier = if (iconEnabled) {
        Modifier.padding(start = 4.dp, end = 12.dp)
    } else Modifier.padding(horizontal = 12.dp)

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) Purple100 else Gray300,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = {
                        isSelected = !isSelected
                        if  (isSelected) value?.invoke(name)
                    }
                )
        ) {
            if (iconEnabled) {
                Icon(
                    icon,
                    "",
                    tint = if (isSelected) Green else Red,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .width(24.dp)
                )
            }

            Text(
                text = name,
                color = if (isSelected) Purple500 else Gray700,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = modifier
            )
        }
    }
}