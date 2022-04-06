class MyViewModel : ViewModel() {
    var isClicked = MutableStateFlow(false)
    var text = MutableLiveData<String>()

    fun onToggle() {
        isClicked.value = !isClicked.value
    }

    fun onValueChanged(input: String) {
        text.value = input
    }
}

@Composable
private fun ObservableTypeExample(model: MyViewModel) {
    val text: String by model.text.observeAsState("")
    val isClicked: Boolean by model.isClicked.collectAsState()

    MyScreen(
        text = text,
        isClicked = isClicked,
        onValueChanged = { model.onValueChanged(it) },
        onToggle = { model.onToggle() }
    )
}

@Composable
fun MyScreen(
    text: String,
    isClicked: Boolean,
    onValueChanged: (String) -> Unit,
    onToggle: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { onValueChanged(it) },
        )

        Switch(
            checked = isClicked,
            onCheckedChange = { onToggle() }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (isClicked) Green200 else Blue200
                )
        )
    }
}