package de.check24.compose.demo.features.stateless

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.StatefulBinding

class AndroidUIStatelessActivity : AppCompatActivity() {

    private lateinit var binding: StatefulBinding
    private var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.stateful)
        supportActionBar?.title = "Stateless"
        binding = StatefulBinding.inflate(layoutInflater)
        binding.switchExample.setOnClickListener {
            if (isClicked) {
                binding.box.setBackgroundColor(resources.getColor(R.color.blue_200))
            } else {
                binding.box.setBackgroundColor(resources.getColor(R.color.green_200))
            }
            isClicked = !isClicked
        }
    }
}