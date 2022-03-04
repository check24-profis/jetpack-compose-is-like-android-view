package de.check24.demo.features.password.visibility

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIPasswordVisibilityToggleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_visibility_toggle)
    }
}