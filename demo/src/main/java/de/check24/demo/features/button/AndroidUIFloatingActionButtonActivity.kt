package de.check24.demo.features.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIFloatingActionButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.floatingactionbutton)
        supportActionBar?.title = "Floating Action Button"
    }
}