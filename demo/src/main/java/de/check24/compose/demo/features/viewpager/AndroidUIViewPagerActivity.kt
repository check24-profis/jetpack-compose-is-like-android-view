package de.check24.compose.demo.features.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import de.check24.compose.demo.R

class AndroidUIViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager)
        supportActionBar?.title = "View Pager"

        val viewPager = findViewById<ViewPager2>(R.id.view_pager_view)
        viewPager.adapter = ViewPagerAdapter(this)
    }
}



