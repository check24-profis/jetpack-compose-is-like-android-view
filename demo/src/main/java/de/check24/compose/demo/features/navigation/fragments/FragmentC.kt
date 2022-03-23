package de.check24.compose.demo.features.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import de.check24.compose.demo.R

class FragmentC : Fragment(R.layout.navigation_plain_text) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.navigation_plain_text, container, false)

        val textView = view.findViewById<TextView>(R.id.plain_text)

        textView.text = "C"

        return view
    }
}