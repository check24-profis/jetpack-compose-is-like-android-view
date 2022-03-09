package de.check24.demo.features.constraintlayout.group

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import de.check24.demo.R

class AndroidUIGroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_sample)
        supportActionBar?.title = "Constraint Layout (Group)"

        val toggle = findViewById<Button>(R.id.button_group_visibility)
        val group = findViewById<Group>(R.id.group1)

        toggle.setOnClickListener {
            with(group) {
                if (isVisible) {
                    it.visibility = View.INVISIBLE
                } else {
                    it.visibility = View.VISIBLE
                }
            }
        }
    }
}