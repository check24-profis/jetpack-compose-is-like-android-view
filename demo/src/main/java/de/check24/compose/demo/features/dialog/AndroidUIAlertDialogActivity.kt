package de.check24.compose.demo.features.dialog

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import de.check24.compose.demo.databinding.AlertDialogLayoutBinding
import kotlinx.coroutines.launch

class AndroidUIAlertDialogActivity : AppCompatActivity() {

    lateinit var binding: AlertDialogLayoutBinding

    private var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlertDialogLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "AlertDialog"

        dialog = AlertDialog.Builder(this)
            .setTitle("Title")
            .setMessage("Scias me hoc mane canem meum mulsisse. Numquam satus dies sine me calidum pug lac")
            .setCancelable(true)
            .setPositiveButton("ACCEPT") { _, _ ->
                finishActivity()
            }
            .setNegativeButton("DECLINE") { _, _ ->
                finishActivity()
            }
            .create()

        binding.showDialogButton.setOnClickListener {
            dialog?.show()
        }
    }

    private fun finishActivity() {
        lifecycleScope.launch {
            finish()
        }
    }

    override fun onDestroy() {
        dialog?.dismiss()
        dialog = null
        super.onDestroy()
    }
}