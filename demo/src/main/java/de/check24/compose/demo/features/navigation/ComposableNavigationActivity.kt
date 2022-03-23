package de.check24.compose.demo.features.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.check24.compose.demo.theme.DemoTheme

class ComposableNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "NavHost")
                            })
                    }, content = {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {

                            NavHostDemo()
                        }
                    }
                )
            }
        }
    }

}

@Composable
private fun NavHostDemo() {

    val navController = rememberNavController()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        NavHost(navController = navController, startDestination = "A") {

            composable("A") {
                Text(text = "A")
            }

            composable("B") {
                Text(text = "B")
            }

            composable("C") {
                Text(text = "C")
            }
        }

        Row {

            Button(onClick = { navController.navigate("A") }) {
                Text(text = "A")
            }

            Button(onClick = { navController.navigate("B") }) {
                Text(text = "B")
            }

            Button(onClick = { navController.navigate("C") }) {
                Text(text = "C")
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun NavHostDemoPreview() {
    DemoTheme {
        NavHostDemo()
    }
}
