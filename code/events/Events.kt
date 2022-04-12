// brief explanation, states are given by the parents to the children.
// The children, on the other hand, only give events to the parents.
// Thus we have a unidirectional flow.

@Composable
fun EventsExample() {
    // this is the parent class
    // it contains the child and gives down the states
    // ideally only the parent changes the states
    var number by remember { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // here it gives the states to the child
        EventText(number = number.toString())

        // between the curly brackets, the parent can decide what should happen when an event occurs.
        AddButton {
            number++
        }

        SubtractButton {
            number--
        }
    }

}

@Composable
fun EventText(number: String) {
    // the child can't change the state, in this case number.
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Green200),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // the number displayed depends on the state
            text = number,
            fontSize = 24.sp,
            color = White
        )
    }
}

@Composable
fun AddButton(onClick: () -> Unit) {
    // if the child is clicked, an event is sent to the parents.
    Button(
        onClick = { onClick() },
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "ADD +1")
    }
}

@Composable
fun SubtractButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() }
    ) {
        Text(text = "ADD -1")
    }
}