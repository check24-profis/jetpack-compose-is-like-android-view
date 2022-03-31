@Composable
fun IconTabs(tabData: List<ImageVector>) {
    var tabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color.White
    ) {
        tabData.forEachIndexed { index, icon ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, icon = {
                Icon(imageVector = icon, contentDescription = null)
            })
        }
    }
}

@Composable
fun TextTabs(tabData: List<String>) {
    var tabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color.White
    ) {
        tabData.forEachIndexed { index, text ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, text = {
                Text(text = text)
            })
        }
    }
}

@Composable
fun IconAndTextTabs(tabData: List<Pair<String, ImageVector>>) {
    var tabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color.White,
    ) {
        tabData.forEachIndexed { index, pair ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, text = {
                Text(text = pair.first)
            }, icon = {
                Icon(imageVector = pair.second, contentDescription = null)
            })
        }
    }
}