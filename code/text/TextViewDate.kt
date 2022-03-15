@Composable
fun Date() {

    var datePicked: String by remember {
        mutableStateOf("Date")}

    val updatedDate = { date: String ->
        datePicked = date
    }

    val activity = LocalContext.current as AppCompatActivity

    Text(
        text = datePicked,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier
            .wrapContentSize()
            .clickable { showDatePicker(activity, updatedDate) }
    )
}

private fun showDatePicker(
    activity: AppCompatActivity,
    updatedDate: (String) -> Unit
) {
    val picker = MaterialDatePicker.Builder.datePicker().build()
    picker.show(activity.supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        updatedDate(picker.headerText)
    }
}