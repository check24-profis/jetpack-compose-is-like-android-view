package de.check24.demo.features.date

import android.os.Bundle
import androidx.activity.ComponentActivity
import de.check24.demo.R

class AndroidUIDateActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date)
    }
}