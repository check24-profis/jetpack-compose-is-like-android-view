/* At the time of the implementation there were no official implementation!
* Look if there is an official implementaion already */

@Composable
fun ChipGroupExample() {

    val list = listOf(
        "Chip One",
        [...]
        "Chip Ten"
    )

    val selectedChip = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            items(list) {

                val color by animateColorAsState(
                    if (selectedChip.value == it) {
                        colorResource(id = R.color.purple_200)
                    } else Color.LightGray
                )

                // through row we get a riddle effect over the Text with padding
                Row(
                    modifier = Modifier
                        .background(color)
                        .toggleable(
                            value = false,
                            onValueChange = { }
                        )
                        .clickable {
                            selectedChip.value = it
                        }
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(10.dp),
                    )
                }
                // through this statement there is no spacer after the last element
                if (it != list[list.size - 1])
                    Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}