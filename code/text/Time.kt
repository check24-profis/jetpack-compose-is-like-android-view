@Composable
fun TimeExample() {

    var timePicked: String by remember {
        mutableStateOf("Pick a Time")
    }

    val activity = LocalContext.current as AppCompatActivity

    Text(
        text = timePicked,
        modifier = Modifier
            .clickable {
                showTimePicker(
                    { time: String ->
                        timePicked = time
                    },
                    activity
                )
            }
    )
}

private fun showTimePicker(
    time: (String) -> Unit,
    activity: AppCompatActivity
) {
    val picker = MaterialTimePicker.Builder()
        .setTimeFormat(TimeFormat.CLOCK_24H)
        .build()

    picker.show(activity.supportFragmentManager, picker.toString())

    picker.addOnPositiveButtonClickListener {
        time(
            formatTime(
                picker.hour,
                picker.minute
            )
        )
    }
}

private fun formatTime(hour: Int, minute: Int): String {
    var stringHour = hour.toString()
    var stringMinute = minute.toString()

    if (hour < 10) stringHour = "0$stringHour"
    if (minute < 10) stringMinute = "0$stringMinute"
    return "Time: $stringHour:$stringMinute"
}