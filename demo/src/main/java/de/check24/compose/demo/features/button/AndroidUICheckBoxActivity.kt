package de.check24.compose.demo.features.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUICheckBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkbox)
        supportActionBar?.title = "CheckBox"
    }
}