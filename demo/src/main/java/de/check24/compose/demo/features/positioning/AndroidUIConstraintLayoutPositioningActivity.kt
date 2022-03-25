package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ConstraintLayoutPositioningBinding

class AndroidUIConstraintLayoutPositioningActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout_positioning)
        supportActionBar?.title = "ConstraintLayout"
    }
}