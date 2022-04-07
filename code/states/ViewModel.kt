// the ViewModel manages the states and the events
// it also has access to the business logic and has a longer lifecycle than the composable
class MyViewModel : MyViewModelInterface {
    // states
    override var number = mutableStateOf(0)
    override var isClicked = mutableStateOf(false)

    // events
    fun addNumber() {
        number.value = number.value + 1
    }
    fun toggle(clicked: Boolean) {
        isClicked.value = clicked
    }
}

interface MyViewModelInterface {
    val number: MutableState<Int>
    val isClicked : MutableState<Boolean>

    fun addNumber()
    fun toggle(clicked: Boolean)
}

@Composable
fun MyScreen(myViewModel: MyViewModelInterface) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = myViewModel.number.toString(),
            modifier = Modifier.clickable { myViewModel.addNumber() }
        )

        Switch(
            checked = myViewModel.isClicked.value,
            onCheckedChange = { myViewModel.toggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (myViewModel.isClicked.value) Green200 else Blue200
                )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ViewModelExamplePreview() {
    DemoTheme {
        val myViewModel = object:MyViewModelInterface{
            override val number: MutableState<Int>
                get() = mutableStateOf(0)
            override val isClicked: MutableState<Boolean>
                get() = mutableStateOf(false)

            override fun onClick() {
                number.value = number.value + 1
            }

            override fun onToggle(clicked: Boolean) {
                isClicked.value = clicked
            }
        }
        MyScreen(myViewModelInterface = myViewModel)
    }
}