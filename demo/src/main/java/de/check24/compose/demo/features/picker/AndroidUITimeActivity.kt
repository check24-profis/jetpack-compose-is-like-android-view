package de.check24.compose.demo.features.picker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import de.check24.compose.demo.databinding.TimeBinding

class AndroidUITimeActivity : AppCompatActivity() {

    var binding: TimeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TimeBinding.inflate(layoutInflater)
        if (binding == null) throw Exception("Something with the initialization of the View went wrong")
        setContentView(binding?.root)
        supportActionBar?.title = "Time"

        binding?.timePickerTextView?.setOnClickListener {
            showTimePicker()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    @SuppressLint("SetTextI18n")
    private fun showTimePicker() {

        val materialTimePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .build()

        materialTimePicker.addOnPositiveButtonClickListener {
            binding?.timePickerTextView?.text =
                formatTime(materialTimePicker.hour, materialTimePicker.minute)
        }
        materialTimePicker.show(supportFragmentManager, "TAG")
    }

    private fun formatTime(hour : Int, minute: Int) : String {
        var stringHour = hour.toString()
        var stringMinute = minute.toString()

        if (hour < 10) stringHour = "0$stringHour"
        if (minute < 10) stringMinute = "0$stringMinute"
        return "Time: $stringHour:$stringMinute"
    }
}