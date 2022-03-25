package de.check24.compose.demo.features.framelayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUIFrameLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Frame Layout"
    }
}