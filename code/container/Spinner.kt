@Composable
fun SpinnerExample() {

    val itemList = listOf(
        "Berlin",
        "Hamburg",
        "Stuttgart",
        "München",
        "Düsseldorf",
        "Osnabrück"
    )

    var expanded by remember { mutableStateOf(false) }
    var cityname by remember { mutableStateOf("select a city") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
        ) {
            Text(text = cityname, Modifier.clickable { expanded = !expanded })
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                itemList.forEach { city ->

                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            cityname = city
                        }
                    ) {
                        Text(text = city)
                    }
                }
            }
        }
    }
}
