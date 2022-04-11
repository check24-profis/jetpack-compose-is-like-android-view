package de.check24.compose.demo.features.events

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.EventsBinding

class AndroidUIEventsActivity: AppCompatActivity() {

    lateinit var binding : EventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EventsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Events"

        // ViewModel gibt Infos an Fragment gibt an UserInterface gibt Events an ViewModel


    }
}