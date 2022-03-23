package de.check24.compose.demo.features.navigation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import de.check24.compose.demo.R

class AndroidUINavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_host_screen)
        supportActionBar?.title = "NavHost"

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        val buttonA = findViewById<Button>(R.id.button_a)
        val buttonB = findViewById<Button>(R.id.button_b)
        val buttonC = findViewById<Button>(R.id.button_c)

        buttonA.setOnClickListener {
            navController.navigate(R.id.fragment_a)
        }

        buttonB.setOnClickListener {
            navController.navigate(R.id.fragment_b)
        }

        buttonC.setOnClickListener {
            navController.navigate(R.id.fragment_c)
        }
    }
}