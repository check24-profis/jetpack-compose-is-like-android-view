package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ConstraintLayoutPositioningBinding

class AndroidUIConstraintLayoutPositioningActivity : AppCompatActivity(){

    private var binding: ConstraintLayoutPositioningBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ConstraintLayoutPositioningBinding.inflate(layoutInflater)
        if (binding == null) throw Exception("ConstraintLayoutPositioningBinding could not be bounded")
        setContentView(binding?.root)
//        setContentView(R.layout.constraint_layout_positioning)
        supportActionBar?.title = "ConstraintLayout"
    }
}