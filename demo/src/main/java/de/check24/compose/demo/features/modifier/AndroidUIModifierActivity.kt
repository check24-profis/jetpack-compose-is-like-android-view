package de.check24.compose.demo.features.modifier

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R

class AndroidUIModifierActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modifier)
        supportActionBar?.title = "Modifier"
    }

    @SuppressLint("SetTextI18n")
    fun onTextClick(view: View) {
        if (view.id != R.id.modifier_clickable) return

        count++
        (view as TextView).text = "Clicked ${count}x"
    }
}