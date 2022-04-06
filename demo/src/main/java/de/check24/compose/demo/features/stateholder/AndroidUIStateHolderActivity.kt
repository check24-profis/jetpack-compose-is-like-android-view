package de.check24.compose.demo.features.stateholder

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.StateholderBinding

class AndroidUIStateHolderActivity:AppCompatActivity() {

    private var binding: StateholderBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StateholderBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "State Holder"

        binding?.stateHolderSwitch?.setOnClickListener {
            setBackgroundColor(
                binding?.viewBox,
                requireNotNull(binding?.stateHolderSwitch?.isChecked)
            )
        }
    }

    private fun setBackgroundColor(viewBox: View?, clicked: Boolean) {
        if (clicked) {
            viewBox?.setBackgroundResource(R.color.green_200)
        } else {
            viewBox?.setBackgroundResource(R.color.blue_200)
        }
    }
}