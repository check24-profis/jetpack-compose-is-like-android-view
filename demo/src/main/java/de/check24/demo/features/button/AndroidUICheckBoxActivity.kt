package de.check24.demo.features.button

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import de.check24.demo.R

class AndroidUICheckBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkbox)
        supportActionBar?.title = "CheckBox"
    }

    fun onCheckBoxClicked(view: View) {
        if (view !is CheckBox) return

        val snackbar = Snackbar.make(view, "Checked state is ${view.isChecked}", 250)
        snackbar.show()
    }
}