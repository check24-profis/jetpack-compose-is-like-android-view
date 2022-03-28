package de.check24.compose.demo.features.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.TabLayoutBinding

class AndroidUITabLayoutActivity : AppCompatActivity() {

    private var binding: TabLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TabLayoutBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        binding?.tabLayout?.apply {
            addTab(newTab().setText("A"))
            addTab(newTab().setText("B"))
            addTab(newTab().setText("C"))
        }

        supportActionBar?.title = "Tab Layout"
    }
}