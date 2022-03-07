@Composable
private fun Switch() {
    val checkedState = remember { mutableStateOf(false) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}