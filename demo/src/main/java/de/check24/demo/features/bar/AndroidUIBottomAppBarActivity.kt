package de.check24.demo.features.bar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.check24.demo.R
import de.check24.demo.databinding.BottomAppBarBinding
import de.check24.demo.databinding.FragmentDownloadBinding
import de.check24.demo.features.bar.screens.DownloadFragment
import de.check24.demo.features.bar.screens.FABFragment
import de.check24.demo.features.bar.screens.FavoriteFragment

class AndroidUIBottomAppBarActivity : AppCompatActivity() {


    lateinit var floatingActionButton: FloatingActionButton
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_app_bar)
        supportActionBar?.title = "BottomAppBar"

        val downloadFragment = DownloadFragment()
        val floatingActionButtonFragment = FABFragment()
        val favoriteFragment = FavoriteFragment()

        setCurrentFragment(favoriteFragment)


        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.downloadFragment -> setCurrentFragment(downloadFragment)
                R.id.favoriteFragment -> setCurrentFragment(favoriteFragment)
            }
            true
        }

        floatingActionButton = findViewById(R.id.floating_action_button)
        floatingActionButton.setOnClickListener {
            setCurrentFragment(floatingActionButtonFragment)
            unselectItems(bottomNavigationView)

            /*bottomNavigationView.menu.getItem(2).isCheckable = false
            bottomNavigationView.menu.getItem(2).isChecked = false

            bottomNavigationView.menu.getItem(0).isCheckable = false
            bottomNavigationView.menu.getItem(0).isChecked = false*/
        }
    }

    private fun unselectItems(bottomNavigationView: BottomNavigationView) {

        bottomNavigationView.menu.getItem(0).isCheckable = false
        bottomNavigationView.menu.getItem(0).isChecked = false
        bottomNavigationView.menu.getItem(2).isCheckable = false
        bottomNavigationView.menu.getItem(2).isChecked = false

        bottomNavigationView.menu.getItem(0).isCheckable = true
        bottomNavigationView.menu.getItem(2).isCheckable = true
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }
}