package de.check24.compose.demo.features.viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import de.check24.compose.demo.R

class AndroidUIViewPagerActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager_view)

        viewPager.adapter = ViewPagerAdapter(this)
    }
}

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment = ViewPagerFragment(position)
}

class ViewPagerFragment(private val position: Int) : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        val fragment = inflater.inflate(R.layout.view_pager_fragment, container)
        val textView = fragment.findViewById<TextView>(R.id.view_pager_fragment_text)
        textView.text = "this is page $position"

        return fragment
    }
}