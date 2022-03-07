package de.check24.demo.features.button

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIImageButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_button)
        supportActionBar?.title = "ImageButton"
    }

    fun onImageButtonClick(view: View) {
        if (view !is ImageButton) return


    }
}