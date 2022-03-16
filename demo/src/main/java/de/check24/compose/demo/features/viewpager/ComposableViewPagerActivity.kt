package de.check24.compose.demo.features.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import de.check24.compose.demo.theme.DemoTheme

class ComposableViewPagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
//                Scaffold(
//                    topBar = {
//                        TopAppBar(
//                            title = {
//                                Text(text = "Multiline Text")
//                            })
//                    }, content = {
//                        Box(
//                            modifier = Modifier.fillMaxSize(),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            ViewPagerExample()
//                        }
//                    }
//                )
                ViewPagerExample()
            }
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun ViewPagerExample() {
    HorizontalPager(count = 3) {

    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun MultilineTextPreview() {
    DemoTheme {
        ViewPagerExample()
    }
}