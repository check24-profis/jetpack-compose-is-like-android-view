package de.check24.compose.demo.features.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import de.check24.compose.demo.theme.DemoTheme

class ComposableViewPagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "View Pager")
                            }
                        )
                    }, content = {
                        ViewPagerExample()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun ViewPagerExample() {
    HorizontalPager(count = 5) { page ->
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            elevation = 10.dp,
            backgroundColor = Color.LightGray
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(text = "This is page ${page + 1}")
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ViewPagerPreview() {
    DemoTheme {
        ViewPagerExample()
    }
}