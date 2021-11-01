sealed class ExampleListItems {

    data class TitleItem(
        val title: String
    ) : ExampleListItems()

    data class ContentItem(
        val title: String,
        val body: String
    ) : ExampleListItems()

}


@Composable
fun ExampleItemsListView(listOfExampleItems: List<ExampleListItems>) {
    LazyColumn {
        items(listOfExampleItems) { item ->
            when (item) {
                is ExampleListItems.TitleItem -> TitleItemView(item = item)
                is ExampleListItems.ContentItem -> ContentItemView(item = item)
            }
        }
    }
}


@Composable
fun TitleItemView(item: ExampleListItems.TitleItem) {
    Row(
        modifier = Modifier
            .background(color = Color.LightGray)
            .padding(all = 20.dp)
    ) {
        Text(text = item.title, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ContentItemView(item: ExampleListItems.ContentItem) {
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