package de.check24.compose.demo.features.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUINavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "NavHost"
    }
}