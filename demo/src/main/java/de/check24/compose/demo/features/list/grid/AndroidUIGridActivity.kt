package de.check24.compose.demo.features.list.grid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUIGridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Grid"
    }
}