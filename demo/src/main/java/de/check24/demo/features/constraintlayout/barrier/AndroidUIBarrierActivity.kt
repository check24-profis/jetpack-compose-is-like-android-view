package de.check24.demo.features.constraintlayout.barrier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIBarrierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.barrier)
        supportActionBar?.title = "Constraint Layout (Barrier)"
    }
}