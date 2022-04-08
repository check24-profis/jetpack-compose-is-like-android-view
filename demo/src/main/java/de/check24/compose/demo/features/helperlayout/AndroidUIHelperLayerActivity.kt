package de.check24.compose.demo.features.helperlayout

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.HelperLayerBinding

class AndroidUIHelperLayerActivity : AppCompatActivity() {

    private var binding: HelperLayerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HelperLayerBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Helper (Layer)"

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