package de.check24.compose.demo.features.helperlayout

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.HelperLayoutBinding

class AndroidUIHelperLayoutActivity : AppCompatActivity() {

    private var binding: HelperLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HelperLayoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Helper (Layout)"

        binding?.rotateButton?.setOnClickListener {
            ValueAnimator.ofFloat(0F, 360F)
                .apply {
                    addUpdateListener { animator ->
                        binding?.allViews?.rotation = animator.animatedValue as Float
                    }
                    duration = 2000
                    start()
                }
        }

        binding?.rotateRedAndGreenButton?.setOnClickListener {
            ValueAnimator.ofFloat(0F, 360F)
                .apply {
                    addUpdateListener { animator ->
                        binding?.viewRedAndGreen?.rotation = animator.animatedValue as Float
                    }
                    duration = 2000
                    start()
                }
        }
    }
}