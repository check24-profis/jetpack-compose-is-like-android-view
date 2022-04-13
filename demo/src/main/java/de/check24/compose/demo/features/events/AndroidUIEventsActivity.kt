package de.check24.compose.demo.features.events

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.EventLayoutBinding

class AndroidUIEventsActivity: AppCompatActivity() {

    lateinit var binding: EventLayoutBinding
    private val viewModel: EventViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EventLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Events"

        binding.apply {

            addButton.setOnClickListener {
                viewModel.plusOne()
                textView.text = viewModel.number.toString()
            }

            subtractButton.setOnClickListener {
                viewModel.minusOne()
                textView.text = viewModel.number.toString()
            }
        }
    }
}

class EventViewModel : ViewModel() {
    var number = 0

    fun plusOne() {
        number++
    }

    fun minusOne(){
        number--
    }
}