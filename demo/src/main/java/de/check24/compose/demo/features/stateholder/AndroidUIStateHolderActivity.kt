package de.check24.compose.demo.features.stateholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AndroidUIStateHolderActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "State Holder"
    }
}