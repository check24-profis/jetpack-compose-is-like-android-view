package de.check24.compose.demo.features.sideeffects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.theme.DemoTheme

class ComposableDisposableEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Disposable Effect")
                            }
                        )
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            DisposableEffectDemo()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun DisposableEffectDemo() {

    var isEffectActive by remember { mutableStateOf(true) }
    var count by remember { mutableStateOf(0) }

    if (isEffectActive) {

        DisposableEffect(true) {

            //is called when DisposableEffect leaves composition
            onDispose { count++ }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Disposed $count times")

        Button(onClick = { isEffectActive = !isEffectActive }) {

            Text(
                text = if (isEffectActive) "Deactivate"
                else "Activate"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DisposableEffectDemoPreview() {
    DemoTheme {
        DisposableEffectDemo()
    }
}