package de.check24.compose.demo.features.list.differentviews

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.RecyclerViewListBinding

class AndroidUIListWithDifferentViewsActivity : AppCompatActivity() {

    var binding: RecyclerViewListBinding? = null
    var adapter: DifferentViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Different View List"

        binding = RecyclerViewListBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(binding?.root)
        adapter = DifferentViewAdapter()
        binding?.recyclerView?.adapter = adapter

        val exampleList = mutableListOf(
            ExampleListItems.TitleItem("I am a title"),
            ExampleListItems.TitleItem("I am a title"),
            ExampleListItems.ContentItem("I am a title", "I am body"),
            ExampleListItems.TitleItem("I am a title")
        )
        adapter?.submitList(exampleList)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        adapter = null
    }
}