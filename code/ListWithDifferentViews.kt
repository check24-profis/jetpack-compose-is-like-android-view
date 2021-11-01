sealed class ExampleListItems {

    data class TitleItemData(
        val title: String
    ) : ExampleListItems()

    data class ContentItemData(
        val title: String,
        val body: String
    ) : ExampleListItems()

}


@Composable
fun ItemList(listOfExampleItems: List<ExampleListItems>) {
    LazyColumn {
        items(listOfExampleItems) { item ->
            when (item) {
                is ExampleListItems.TitleItemData -> TitleItem(item = item)
                is ExampleListItems.ContentItemData -> ContentItem(item = item)
            }
        }
    }
}


@Composable
fun TitleItem(item: ExampleListItems.TitleItemData) {
    Row(
        modifier = Modifier
            .background(color = Color.LightGray)
            .padding(all = 20.dp)
    ) {
        Text(text = item.title, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ContentItem(item: ExampleListItems.ContentItemData) {
    Row(
        modifier = Modifier
            .background(color = Color.Cyan)
            .padding(all = 20.dp)
    ) {
        Column() {
            Text(text = item.title, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = item.body, fontWeight = FontWeight.ExtraLight)
        }
    }
}