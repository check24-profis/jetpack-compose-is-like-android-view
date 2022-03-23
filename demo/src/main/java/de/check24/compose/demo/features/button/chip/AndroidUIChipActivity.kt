package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.res.colorResource
import androidx.core.view.isVisible
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ChipBinding

// if ChipBinding says "no reference" just Build -> Clean Project

class AndroidUIChipActivity : AppCompatActivity() {

    private var binding: ChipBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChipBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Chip"

        binding?.inputChip?.setOnCloseIconClickListener {
            binding?.inputChip?.isVisible = false
        }

        val outlinedChip = binding?.outlinedChip
        outlinedChip?.setOnClickListener {
            if (outlinedChip.isChecked) {
                outlinedChip.setChipBackgroundColorResource(R.color.purple_100)
            } else {
                outlinedChip.setChipBackgroundColorResource(R.color.white)
            }
        }

    }
}