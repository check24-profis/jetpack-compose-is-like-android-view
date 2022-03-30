package de.check24.compose.demo.features.theme

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIThemeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.theme_demo_layout)
        supportActionBar?.title = "Theme"
    }
}