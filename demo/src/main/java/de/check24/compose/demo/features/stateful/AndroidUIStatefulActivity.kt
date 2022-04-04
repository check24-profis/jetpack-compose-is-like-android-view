package de.check24.compose.demo.features.stateful

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.StatefulBinding

class AndroidUIStatefulActivity : AppCompatActivity() {

    private var binding: StatefulBinding? = null
    private var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StatefulBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Stateful"

        binding?.switchExample?.setOnClickListener {
            if (isClicked) {
                binding?.box?.setBackgroundColor(resources.getColor(R.color.blue_200))
            } else {
                binding?.box?.setBackgroundColor(resources.getColor(R.color.green_200))
            }
            isClicked = !isClicked
        }
    }
}