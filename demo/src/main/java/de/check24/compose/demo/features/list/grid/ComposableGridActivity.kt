package de.check24.compose.demo.features.list.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Purple200
import de.check24.compose.demo.theme.Purple700

class ComposableGridActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Grid")
                            })
                    }, content = {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            GridExample()

                            Spacer(modifier = Modifier.height(100.dp))

                            FixedGridExample()
                        }

                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun GridExample() {

    val colorList = listOf(
        Color.Red,
        Color.Black,
        Purple200,
        Purple700
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.size(200.dp)
    ) {

        (0..3).forEach {

            item {

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(colorList[it])
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GridExamplePreview() {
    DemoTheme {
        GridExample()
    }
}