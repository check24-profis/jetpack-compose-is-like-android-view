@Composable
fun Date() {

    val activity = LocalContext.current as AppCompatActivity

    val datePicker = MaterialDatePicker.Builder.datePicker().build()
    datePicker.show(activity.supportFragmentManager, datePicker.toString())
}