@Composable
fun RadioGroup() {

    val stringList = listOf(
        "First Radio Button",
        "Second Radio Button",
        "Third Radio Button"
    )

    val rememberObserver = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        stringList.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(selected = rememberObserver.value == item,
                    onClick = {
                        rememberObserver.value = item
                    }
                )
                Text(
                    text = item,
                    modifier = Modifier.clickable { rememberObserver.value = item }
                )
            }
        }
    }
}