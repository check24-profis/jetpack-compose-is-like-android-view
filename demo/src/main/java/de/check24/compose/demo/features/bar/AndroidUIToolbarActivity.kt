package de.check24.compose.demo.features.bar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ToolbarBinding

class AndroidUIToolbarActivity : AppCompatActivity() {

    private var binding: ToolbarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ToolbarBinding.inflate(layoutInflater)
        if (binding == null) throw Exception("Layout did not git inflated")
        setContentView(binding?.root)
        supportActionBar?.hide()


        binding?.toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}