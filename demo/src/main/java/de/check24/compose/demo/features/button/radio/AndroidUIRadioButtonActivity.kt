package de.check24.compose.demo.features.button.radio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIRadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_button)
        supportActionBar?.title = "Radio Button"
    }
}