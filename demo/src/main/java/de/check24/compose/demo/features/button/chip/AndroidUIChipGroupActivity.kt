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

        binding?.apply {
            filterChipOne.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipTwo.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipThree.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipFour.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipFive.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipSix.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipSeven.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipEight.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipNine.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
            filterChipTen.setOnCloseIconClickListener {
                binding?.chipGroupFilterSelection?.removeView(it)
            }
        }
    }
}