package de.check24.compose.demo.features.appbarlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.AppBarLayoutBinding

class AndroidUIAppBarLayoutActivity : AppCompatActivity() {

    private var binding: AppBarLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = AppBarLayoutBinding.inflate(layoutInflater)
        binding?.toolbar?.navigationIcon?.setTint(0xFFFFFFFF.toInt())

        setContentView(binding?.root)
    }
}