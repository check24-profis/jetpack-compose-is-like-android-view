package de.check24.demo.features.bar

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.check24.demo.R
import de.check24.demo.features.bar.screens.DownloadScreen
import de.check24.demo.features.bar.screens.FavoriteScreen
import de.check24.demo.features.bar.screens.FloatingActionButtonScreen
import de.check24.demo.ui.theme.DemoTheme

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
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Favorite : BottomBarScreen(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )

    object Download : BottomBarScreen(
        route = "download",
        title = "Download",
        icon = Icons.Default.Download
    )

    object FloatingActionButton : BottomBarScreen(
        route = "fab",
        title = "FloatingActionButton",
        icon = Icons.Default.Add
    )
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Favorite.route
    ) {
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomBarScreen.Download.route) {
            DownloadScreen()
        }
        composable(route = BottomBarScreen.FloatingActionButton.route) {
            FloatingActionButtonScreen()
        }
    }
}

@Composable
private fun BottomAppBarExample() {

    val navController = rememberNavController()

    val screens = listOf(
        BottomBarScreen.Favorite,
        BottomBarScreen.Download
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(cutoutShape = CircleShape) {
                BottomNavigation() {
                    screens.forEach { screen ->
                        BottomNavigationItem(
                            label = { Text(text = screen.title) },
                            icon = {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = "Navigation Icon"
                                )
                            },
                            selected = currentDestination?.route == screen.route,
                            onClick = { navController.navigate(screen.route) },
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { navController.navigate(BottomBarScreen.FloatingActionButton.route) }
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Floating Action Button"
                )
            }
        },
    ) {
        BottomNavGraph(navController = navController)
    }

    /*val items = listOf(
        Screen.Favorites,
        Screen.Downloads
    )*/


    /*val selectedItem = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                content = {
                    BottomNavigation(
                    ) {
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    Icons.Filled.Favorite,
                                    "favorite icon"
                                )
                            },
                            label = { Text(text = "Favorite") },
                            selected = selectedItem.value == "favorite",
                            onClick = {
                                selectedItem.value = "favorite"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            selected = false,
                            onClick = { },
                            icon = {},
                            enabled = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    Icons.Filled.Download,
                                    "download icon"
                                )
                            },
                            label = {
                                Text(
                                    text = "Download",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            selected = selectedItem.value == "download",
                            onClick = {
                                selectedItem.value = "download"
                            },
                            alwaysShowLabel = false
                        )
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {}
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Floating Action Button"
                )
            }
        },
        content = {},
    )*/
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun BottomAppBarPreview() {
    DemoTheme {
        BottomAppBarPreview()
    }
}