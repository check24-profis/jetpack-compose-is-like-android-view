package de.check24.demo.features.date

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import de.check24.demo.R

class AndroidUIDateActivity : AppCompatActivity() {

    private lateinit var textViewDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date)
        supportActionBar?.title = "Date"

        textViewDate = findViewById(R.id.TextViewDate)
        textViewDate.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val materialDatePicker = MaterialDatePicker.Builder.datePicker()
            .build()

        materialDatePicker.addOnPositiveButtonClickListener {
            textViewDate.text = materialDatePicker.headerText
        }
        materialDatePicker.show(supportFragmentManager, "TAG")
    }
}