package de.check24.compose.demo.features.password.visibility

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIPasswordVisibilityToggleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_visibility_toggle)
        supportActionBar?.title = "Password with visibility toggle"
    }
}