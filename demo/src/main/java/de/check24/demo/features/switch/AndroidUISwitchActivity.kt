package de.check24.demo.features.switch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUISwitchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.uiswitch)
        supportActionBar?.title = "Switch"
    }
}