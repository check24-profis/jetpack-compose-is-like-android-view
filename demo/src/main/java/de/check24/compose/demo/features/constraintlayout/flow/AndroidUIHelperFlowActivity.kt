package de.check24.compose.demo.features.constraintlayout.flow

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.HelperFlowBinding

class AndroidUIHelperFlowActivity: AppCompatActivity() {

    private var binding : HelperFlowBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HelperFlowBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Helper (Flow)"

        val spinnerHorizontalStyle = binding?.spinnerHorizontalStyle
        ArrayAdapter.createFromResource(
            this,
            R.array.flow_style_array,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinnerHorizontalStyle?.adapter = adapter
        }

        spinnerHorizontalStyle?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = parent?.getItemAtPosition(position).toString()
                setFlowStyleAndMode(item)
            }

            private fun setFlowStyleAndMode(item: String) {
                when(item){
                    "packed" -> binding?.flowView?.setHorizontalStyle(Flow.CHAIN_PACKED)
                    "spread" -> binding?.flowView?.setHorizontalStyle(Flow.CHAIN_SPREAD)
                    "spread_inline" -> binding?.flowView?.setHorizontalStyle(Flow.CHAIN_SPREAD_INSIDE)
                }
            }
        }

        val spinnerVerticalStyle = binding?.spinnerVerticalStyle
        ArrayAdapter.createFromResource(
            this,
            R.array.flow_style_array,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinnerVerticalStyle?.adapter = adapter
        }

        spinnerVerticalStyle?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = parent?.getItemAtPosition(position).toString()
                setFlowStyleAndMode(item)
            }

            private fun setFlowStyleAndMode(item: String) {
                when(item){
                    "packed" -> binding?.flowView?.setVerticalStyle(Flow.CHAIN_PACKED)
                    "spread" -> binding?.flowView?.setVerticalStyle(Flow.CHAIN_SPREAD)
                    "spread_inline" -> binding?.flowView?.setVerticalStyle(Flow.CHAIN_SPREAD_INSIDE)
                }
            }
        }

        val spinnerWrapMode = binding?.spinnerWrapMode
        ArrayAdapter.createFromResource(
            this,
            R.array.flow_wrap_mode,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinnerWrapMode?.adapter = adapter
        }

        spinnerWrapMode?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = parent?.getItemAtPosition(position).toString()
                setFlowStyleAndMode(item)
            }

            private fun setFlowStyleAndMode(item: String) {
                when(item) {
                    "chain" -> binding?.flowView?.setWrapMode(Flow.WRAP_CHAIN)
                    "aligned" -> binding?.flowView?.setWrapMode(Flow.WRAP_ALIGNED)
                    "none" -> binding?.flowView?.setWrapMode(Flow.WRAP_NONE)
                }
            }
        }
    }
}