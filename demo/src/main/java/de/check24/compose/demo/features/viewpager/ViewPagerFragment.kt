package de.check24.compose.demo.features.viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ViewPagerBinding
import de.check24.compose.demo.databinding.ViewPagerFragmentBinding

internal class ViewPagerFragment(private val position: Int) : Fragment() {

    private lateinit var binding: ViewPagerFragmentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewPagerFragmentBinding.inflate(inflater, container, false)
        binding.viewPagerFragmentText.text = "This is page ${position + 1}"
        return binding.root
    }
}