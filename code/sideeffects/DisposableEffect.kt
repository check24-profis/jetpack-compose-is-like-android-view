@Composable
fun DisposableEffectDemo() {

    var isEffectActive by remember { mutableStateOf(true) }
    var count by remember { mutableStateOf(0) }
    var disposableEffectKey by remember { mutableStateOf(true) }

    if (isEffectActive) {

        DisposableEffect(disposableEffectKey) {

            //is called when DisposableEffect leaves composition or key changed
            onDispose { count++ }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Disposed $count times")

        Button(onClick = { isEffectActive = !isEffectActive }) {

            Text(
                text = if (isEffectActive) "Deactivate"
                else "Activate"
            )
        }

        Button(onClick = { disposableEffectKey = !disposableEffectKey }) {

            Text(text = "Change key")
        }
    }
}