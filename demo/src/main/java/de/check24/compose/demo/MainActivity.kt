package de.check24.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices.NEXUS_6
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.theme.DemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Menu()
            }
        }
    }
}


/**
 * Add [CompareUIItem] for every section here
 */
@Composable
private fun Menu() {
    LazyColumn {

        items(compareItemList) { item ->
            CompareUIItem(
                composeActivity = item.composeActivity,
                androidUIActivity = item.androidUIActivity,
                headline = item.headline
            )
        }

        items(singleItemList) { item ->

        }
    }
}


@Preview(showBackground = true, device = NEXUS_6, showSystemUi = true)
@Composable
private fun MenuPreview() {
    DemoTheme {
        Menu()
    }
}

