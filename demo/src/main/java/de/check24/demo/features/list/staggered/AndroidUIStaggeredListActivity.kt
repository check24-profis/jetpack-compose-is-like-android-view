package de.check24.demo.features.list.staggered

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import de.check24.demo.databinding.StaggeredRecyclerViewBinding
import kotlin.random.Random

class AndroidUIStaggeredListActivity : AppCompatActivity() {

    private var binding: StaggeredRecyclerViewBinding? = null
    private var adapter : StaggeredAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StaggeredRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        adapter = StaggeredAdapter()
        binding?.staggeredRecyclerView?.adapter = adapter
        adapter?.submitList(createColorList())
        supportActionBar?.title = "Staggered List"
    }

    private fun createColorList(): MutableList<Int> {
        val colorList = mutableListOf<Int>()
        (1..100).forEach {
            colorList.add(Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
        }
       return colorList
    }
}