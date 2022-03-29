package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIHorizontalLinearLayoutPositioningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horizontal_linear_layout)
        supportActionBar?.title = "LinearLayout Horizontal"
    }
}