package de.check24.demo.features.list.differentviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.demo.R

class AndroidUIListWithDifferentViewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_list)
        supportActionBar?.title = "Different View List"
    }
}