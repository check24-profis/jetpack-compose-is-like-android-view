package de.check24.compose.demo.features.modifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUIModifierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Modifier"
    }
}