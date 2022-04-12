package de.check24.compose.demo.features.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import de.check24.compose.demo.databinding.EventLayoutBinding

class EventFragment : Fragment() {

    private lateinit var viewModel: EventViewModel
    private var binding: EventLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventLayoutBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[EventViewModel::class.java]

        binding?.apply {

            addButton.setOnClickListener {
                viewModel.plusOne()
                textView.text = viewModel.number.toString()
            }

            subtractButton.setOnClickListener {
                viewModel.minusOne()
                textView.text = viewModel.number.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}