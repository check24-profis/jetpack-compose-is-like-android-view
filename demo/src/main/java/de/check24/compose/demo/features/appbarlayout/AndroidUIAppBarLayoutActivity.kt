package de.check24.compose.demo.features.appbarlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUIAppBarLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "App Bar Layout"
    }
}