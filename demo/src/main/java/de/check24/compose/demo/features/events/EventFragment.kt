package de.check24.compose.demo.features.events

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.EventFragmentBinding

class EventFragment : Fragment() {

    companion object {
        fun newInstance() = EventFragment()
    }

    private lateinit var viewModel: EventViewModel
    private var binding: EventFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventFragmentBinding.inflate(inflater, container, false)
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