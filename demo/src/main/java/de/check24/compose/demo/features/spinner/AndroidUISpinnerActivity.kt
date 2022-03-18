package de.check24.compose.demo.features.spinner

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.SpinnerExampleBinding

class AndroidUISpinnerActivity : AppCompatActivity() {

    private lateinit var binding: SpinnerExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SpinnerExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Spinner"

        val spinner = binding.spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner_array,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}