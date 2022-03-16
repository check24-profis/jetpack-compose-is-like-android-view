package de.check24.compose.demo.features.viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import de.check24.compose.demo.R

internal class ViewPagerFragment(private val position: Int) : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragment = inflater.inflate(R.layout.view_pager_fragment, container)
        val textView = fragment.findViewById<TextView>(R.id.view_pager_fragment_text)
        textView.text = "this is page $position"

        return fragment
    }
}