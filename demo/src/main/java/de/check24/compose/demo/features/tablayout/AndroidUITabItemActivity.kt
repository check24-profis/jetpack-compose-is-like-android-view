package de.check24.compose.demo.features.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.R
import de.check24.compose.demo.databinding.TabItemBinding

class AndroidUITabItemActivity : AppCompatActivity(){

    private lateinit var binding : TabItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TabItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "TabItem"

        binding.tabItemText.apply {
            addTab(newTab().setText("MUSIC"))
            addTab(newTab().setText("MARKET"))
            addTab(newTab().setText("FILMS"))
            addTab(newTab().setText("BOOKS"))
        }

        binding.tabItemIcons.apply {
            addTab(newTab().setIcon(R.drawable.ic_baseline_save_24))
            addTab(newTab().setIcon(R.drawable.ic_baseline_date_range))
            addTab(newTab().setIcon(R.drawable.ic_baseline_favorite_24))
            addTab(newTab().setIcon(R.drawable.ic_baseline_cloud_download_24))
        }

        binding.tabItemTextAndIcons.apply {
            addTab(newTab().setText("MUSIC").setIcon(R.drawable.ic_baseline_save_24))
            addTab(newTab().setText("MARKET").setIcon(R.drawable.ic_baseline_date_range))
            addTab(newTab().setText("FILMS").setIcon(R.drawable.ic_baseline_favorite_24))
            addTab(newTab().setText("BOOKS").setIcon(R.drawable.ic_baseline_cloud_download_24))
        }
    }
}