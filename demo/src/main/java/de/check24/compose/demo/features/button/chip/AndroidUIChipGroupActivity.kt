package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.ChipGroupBinding

class AndroidUIChipGroupActivity : AppCompatActivity() {

    private var binding: ChipGroupBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChipGroupBinding.inflate(layoutInflater)
        if (binding == null) throw Exception("ChipGroup view could not be bound, cause it was null")
        setContentView(binding?.root)
        supportActionBar?.title = "Chip Group"

        binding?.filterChipOne?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipTwo?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipThree?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipFour?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipFive?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipSix?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipSeven?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipEight?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipNine?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }

        binding?.filterChipTen?.setOnCloseIconClickListener {
            binding?.chipGroupFilterSelection?.removeView(it)
        }
    }
}