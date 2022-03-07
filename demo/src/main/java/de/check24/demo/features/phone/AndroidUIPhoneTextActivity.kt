package de.check24.demo.features.phone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIPhoneTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_number)
        supportActionBar?.title = "Phone Number"
    }
}