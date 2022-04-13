// Vertical FlowLayout
// the crossAxisAlignment doesn't work properly

FlowColumn(
    modifier = Modifier
        .height(300.dp)
        .wrapContentWidth(),
    mainAxisAlignment = FlowMainAxisAlignment.Center,
    mainAxisSpacing = 16.dp,
    crossAxisSpacing = 50.dp,
    crossAxisAlignment = FlowCrossAxisAlignment.Center,
) {
    // add here your view elements
}

// Horizontal FlowLayout
// the crossAxisAlignment doesn't work properly

FlowRow(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(20.dp),
    mainAxisAlignment = FlowMainAxisAlignment.Center,
    crossAxisSpacing = 16.dp,
    mainAxisSpacing = 16.dp
) {
    // add here your code
}