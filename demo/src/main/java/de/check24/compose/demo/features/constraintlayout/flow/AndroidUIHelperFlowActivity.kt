package de.check24.compose.demo.features.constraintlayout.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIHelperFlowActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.helper_flow)
        supportActionBar?.title = "Helper (Flow)"
    }
}