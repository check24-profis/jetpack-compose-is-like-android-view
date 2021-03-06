package de.check24.compose.demo.features.bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.features.bar.screens.DownloadScreen
import de.check24.compose.demo.features.bar.screens.FavoriteScreen
import de.check24.compose.demo.theme.DemoTheme

class ComposableBottomAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                BottomAppBarExample()
            }
        }
    }
}

sealed class BottomBarScreen(
    val title: String,
    val icon: ImageVector
) {
    object Favorite : BottomBarScreen(
        title = "Favorite",
        icon = Icons.Default.Favorite
    )

    object Download : BottomBarScreen(
        title = "Download",
        icon = Icons.Default.Download
    )
}

@Composable
private fun BottomAppBarExample() {

    val screens = listOf(
        BottomBarScreen.Favorite,
        BottomBarScreen.Download
    )

    var currentScreen by remember { mutableStateOf<BottomBarScreen>(BottomBarScreen.Favorite) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBarDetails(screens, currentScreen) {
                screen ->
                currentScreen = screen
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButtonDetails()
        },
    ) {
        when (currentScreen) {
            BottomBarScreen.Favorite -> FavoriteScreen()
            BottomBarScreen.Download -> DownloadScreen()
        }
    }
}

@Composable
private fun BottomAppBarDetails(
    screens: List<BottomBarScreen>,
    currentScreen: BottomBarScreen,
    onClick : (BottomBarScreen) -> Unit
) {
    BottomAppBar(cutoutShape = CircleShape) {
        screens.forEach { screen ->
            BottomNavigationItem(
                label = { Text(text = screen.title) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation Icon"
                    )
                },
                selected = screen == currentScreen,
                onClick = {
                    onClick(screen)
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun FloatingActionButtonDetails() {
    FloatingActionButton(
        shape = CircleShape,
        onClick = { /* your code */ }
    ) {
        Icon(
            Icons.Filled.Add,
            "Floating Action Button"
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun BottomAppBarPreview() {
    DemoTheme {
        BottomAppBarPreview()
    }
}