package de.check24.compose.demo.features.stateless

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.StatefulBinding

class AndroidUIStatelessActivity : AppCompatActivity() {

    private lateinit var binding: StatefulBinding
    private var isChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StatefulBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Stateless"

        binding.switchExample.setOnClickListener {
            setColorOnValueChanged()
        }
    }

    private fun setColorOnValueChanged() {
        if (isChecked) {
            binding.box.setBackgroundColor(resources.getColor(R.color.blue_200))
        } else {
            binding.box.setBackgroundColor(resources.getColor(R.color.green_200))
        }
        isChecked = !isChecked
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
        outState.putBoolean("state", true)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isChecked = savedInstanceState.getBoolean("state")
        setColorOnValueChanged()
    }
}

