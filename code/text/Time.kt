@SuppressLint("SetTextI18n")
fun showTimePicker() {

    val materialTimePicker = MaterialTimePicker.Builder()
        .setTimeFormat(TimeFormat.CLOCK_24H)
        .build()

    materialTimePicker.addOnPositiveButtonClickListener {
        binding.timePickerTextView.text = ""
        binding.timePickerTextView.text =
            correctsTime(materialTimePicker.hour, materialTimePicker.minute)

    }
    materialTimePicker.show(supportFragmentManager, "TAG")
}

private fun correctsTime(hour : Int, minute: Int) : String {
    var stringHour = hour.toString()
    var stringMinute = minute.toString()

    if (hour < 10) stringHour = "0$stringHour"
    if (minute < 10) stringMinute = "0$stringMinute"
    return "Time: $stringHour:$stringMinute"
}