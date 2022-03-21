package de.check24.compose.demo.features.text

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.AutoCompleteBinding

class AndroidUIAutoCompleteActivity : AppCompatActivity() {

    private lateinit var binding: AutoCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AutoCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Auto Complete"

        val countriesList = resources.getStringArray(R.array.auto_complete_array)
        val arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, countriesList)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }
}