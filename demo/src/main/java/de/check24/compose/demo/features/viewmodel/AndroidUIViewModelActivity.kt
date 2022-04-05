package de.check24.compose.demo.features.viewmodel

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ViewmodelBinding

class AndroidUIViewModelActivity : AppCompatActivity() {

    private var binding: ViewmodelBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MyAndroidViewViewModel by viewModels()
        super.onCreate(savedInstanceState)
        binding = ViewmodelBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "ViewModel"

        setBackgroundColor(viewModel.isClicked, requireNotNull(binding?.boxView))
        binding?.textView?.text = viewModel.number.toString()

        binding?.viewModelSwitch?.setOnClickListener {
            viewModel.onToggle()
            setBackgroundColor(viewModel.isClicked, requireNotNull(binding?.boxView))
        }

        binding?.textView?.setOnClickListener {
            viewModel.onClick()
            binding?.textView?.text = viewModel.number.toString()
        }
    }

    private fun setBackgroundColor(clicked: Boolean, boxView: View) {
        if (clicked) {
            boxView.setBackgroundResource(R.color.green_200)
        } else {
            boxView.setBackgroundResource(R.color.blue_200)
        }
    }
}

class MyAndroidViewViewModel : ViewModel() {
    var isClicked: Boolean = false
    var number: Int = 0

    fun onToggle() {
        isClicked = !isClicked
    }

    fun onClick() {
        number++
    }
}