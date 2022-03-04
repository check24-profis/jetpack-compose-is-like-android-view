package de.check24.demo.features.text

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUITextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plain_text_view)
        supportActionBar?.title = "TextView"
    }
}