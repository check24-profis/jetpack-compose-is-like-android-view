package de.check24.demo.features.date

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIDateActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date)
        supportActionBar?.title = "Date"
    }
}