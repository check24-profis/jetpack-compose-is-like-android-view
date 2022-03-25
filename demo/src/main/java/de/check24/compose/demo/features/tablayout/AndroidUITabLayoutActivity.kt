package de.check24.compose.demo.features.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUITabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Tab Layout"
    }
}