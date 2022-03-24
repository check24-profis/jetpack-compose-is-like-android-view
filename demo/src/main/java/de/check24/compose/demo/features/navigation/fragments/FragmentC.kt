package de.check24.compose.demo.features.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.NavigationPlainTextBinding

class FragmentC : Fragment(R.layout.navigation_plain_text) {

    private var binding: NavigationPlainTextBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = NavigationPlainTextBinding.inflate(inflater, container, false)

        binding?.plainText?.text = "C"

        return binding?.root
    }
}