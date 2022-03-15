package de.check24.demo.features.bar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.check24.demo.R
import de.check24.demo.databinding.BottomAppBarBinding
import de.check24.demo.features.bar.screens.DownloadFragment
import de.check24.demo.features.bar.screens.FavoriteFragment

class AndroidUIBottomAppBarActivity : AppCompatActivity() {

    lateinit var binding: BottomAppBarBinding
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BottomAppBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "BottomAppBar"

        val downloadFragment = DownloadFragment()
        val favoriteFragment = FavoriteFragment()

        setCurrentFragment(favoriteFragment)

        bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.downloadFragment -> {
                    setCurrentFragment(downloadFragment)
                }
                R.id.favoriteFragment -> {
                    setCurrentFragment(favoriteFragment)
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
//            addToBackStack("Fragment")
            commit()
        }
}