package de.check24.compose.demo.features.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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
                        NavHostDemo()
                    }
                )
            }
        }
    }

}

@Composable
private fun NavHostDemo() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "A") {
        
        composable("A") {
            Text(text = "A", )
        }
        
        composable("B") {
            
        }
        
        composable("C") {
            
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
