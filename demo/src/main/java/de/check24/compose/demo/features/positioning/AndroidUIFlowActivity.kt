package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R


class AndroidUIFlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flow_layout)
        supportActionBar?.title = "Flow"
    }
}