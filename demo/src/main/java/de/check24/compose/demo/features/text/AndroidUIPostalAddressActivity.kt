package de.check24.compose.demo.features.text

import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIPostalAddressActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.postal_address)
        supportActionBar?.title = "Postal Address"
    }
}