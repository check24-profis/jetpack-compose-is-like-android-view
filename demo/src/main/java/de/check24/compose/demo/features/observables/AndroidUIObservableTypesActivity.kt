package de.check24.compose.demo.features.observables

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.ObservableTypesBinding

class AndroidUIObservableTypesActivity:AppCompatActivity() {

    private var binding: ObservableTypesBinding? = null
    private var viewModel = ObservableViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ObservableTypesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Observable types"

        binding?.observableSwitch?.setOnClickListener {
            viewModel.onClick()
            setBackgroundColor(binding?.viewBox, viewModel.isClicked)
        }
    }

    private fun setBackgroundColor(viewBox: View?, clicked: MutableLiveData<Boolean>) {
        if (clicked.value == true) {
            viewBox?.setBackgroundResource(R.color.green_200)
        } else {
            viewBox?.setBackgroundResource(R.color.blue_200)
        }
    }
}

class ObservableViewModel: ViewModel() {

    val isClicked: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    fun onClick() {
        isClicked.value = !(requireNotNull(isClicked.value))
    }
}