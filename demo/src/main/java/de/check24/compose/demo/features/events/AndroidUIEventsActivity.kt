package de.check24.compose.demo.features.events

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIEventsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.events_fragment)
        supportActionBar?.title = "Events"

        val eventFragment = EventFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.events_container, eventFragment)
            .commit()
    }
}