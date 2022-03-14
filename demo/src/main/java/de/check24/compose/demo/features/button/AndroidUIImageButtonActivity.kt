package de.check24.compose.demo.features.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import de.check24.compose.demo.R

class AndroidUIImageButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.image_button)
        supportActionBar?.title = "ImageButton"

        val imageView = findViewById<android.widget.ImageButton>(R.id.imageButton)

        Glide
            .with(this)
            .load(R.drawable.c24logo)
            .fitCenter()
            .into(imageView)
    }
}