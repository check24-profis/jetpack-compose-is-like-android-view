package de.check24.compose.demo.features.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ViewPagerBinding

class AndroidUIViewPagerActivity : AppCompatActivity() {

    private lateinit var binding : ViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "View Pager"

        binding.viewPagerView.adapter = ViewPagerAdapter(this)
    }
}



