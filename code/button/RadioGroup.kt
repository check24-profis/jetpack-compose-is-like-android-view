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

        stringList.forEach { stringList ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(selected = rememberObserver.value == stringList,
                    onClick = {
                        rememberObserver.value = stringList
                    }
                )
                Text(
                    text = stringList,
                )
            }
        }
    }
}