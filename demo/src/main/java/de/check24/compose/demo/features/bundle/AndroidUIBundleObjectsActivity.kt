package de.check24.compose.demo.features.bundle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.check24.compose.demo.databinding.BundleObjectsBinding

class AndroidUIBundleObjectsActivity : AppCompatActivity() {

    private var binding: BundleObjectsBinding? = null
    private val person = "My name is John Cole"
    private val river1 = "Spree is in Germany"
    private val river2 = "Ishikari is in Japan"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BundleObjectsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "Bundle Objects"

        binding?.textview1?.text = person
        binding?.textview2?.text = river1
        binding?.textView3?.text = river2
    }
}