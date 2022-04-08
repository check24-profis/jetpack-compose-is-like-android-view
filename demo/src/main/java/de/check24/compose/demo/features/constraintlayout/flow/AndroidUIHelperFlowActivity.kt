package de.check24.compose.demo.features.constraintlayout.flow

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.HelperFlowBinding

data class SpinnerAction(val spinner: Spinner, val action: (String) -> Unit)

class AndroidUIHelperFlowActivity : AppCompatActivity() {

    private lateinit var binding: HelperFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HelperFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Helper (Flow)"

        val spinnerActionList: List<SpinnerAction> = listOf(
            SpinnerAction(
                binding.spinnerHorizontalStyle
            ) {

                binding.flowView.apply {

                    when (it) {
                        "packed" -> setHorizontalStyle(Flow.CHAIN_PACKED)
                        "spread" -> setHorizontalStyle(Flow.CHAIN_SPREAD)
                        "spread_inline" -> setHorizontalStyle(Flow.CHAIN_SPREAD_INSIDE)
                    }
                }
            },
            SpinnerAction(
                binding.spinnerVerticalStyle
            ) {

                binding.flowView.apply {

                    when (it) {
                        "packed" -> setVerticalStyle(Flow.CHAIN_PACKED)
                        "spread" -> setVerticalStyle(Flow.CHAIN_SPREAD)
                        "spread_inline" -> setVerticalStyle(Flow.CHAIN_SPREAD_INSIDE)
                    }
                }
            },
            SpinnerAction(
                binding.spinnerWrapMode,
            ) {

                binding.flowView.apply {

                    when (it) {
                        "chain" -> setWrapMode(Flow.WRAP_CHAIN)
                        "aligned" -> setWrapMode(Flow.WRAP_ALIGNED)
                        "none" -> setWrapMode(Flow.WRAP_NONE)
                    }
                }
            }
        )

        spinnerActionList.forEach { spinnerAction ->
            ArrayAdapter.createFromResource(
                this,
                if (spinnerAction.spinner == binding.spinnerWrapMode) R.array.flow_wrap_mode
                else R.array.flow_style_array,
                R.layout.support_simple_spinner_dropdown_item
            ).also { adapter ->
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                spinnerAction.spinner.adapter = adapter
            }

            spinnerAction.spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {}

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val item = parent?.getItemAtPosition(position).toString()
                        spinnerAction.action(item)
                    }
                }
        }
    }
}