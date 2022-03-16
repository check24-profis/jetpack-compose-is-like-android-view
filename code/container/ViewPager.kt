@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerExample() {
    HorizontalPager(count = 5) { page ->
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            elevation = 10.dp,
            backgroundColor = Color.LightGray
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(text = "this is page $page")
            }
        }

    }
}