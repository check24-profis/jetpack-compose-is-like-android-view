package de.check24.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Devices.NEXUS_6
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.theme.DemoTheme

class MainActivity : ComponentActivity() {

    internal data class StateHolder(
        val compareItemList: MutableState<List<CompareItem>>,
        val singleItemList: MutableState<List<SingleItem>>
    )

    private val state = StateHolder(mutableStateOf(compareItemList), mutableStateOf(singleItemList))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Menu(state)
            }
        }
    }
}


/**
 * Add [CompareUIItem] for every section here
 */
@Composable
private fun Menu(state: MainActivity.StateHolder) {
    LazyColumn {


        items(state.singleItemList.value, key = { it.hashCode() }) { item ->
            SingleUIItem(
                UIActivity = item.activity,
                headline = item.headline
            )
        }

        items(state.compareItemList.value, key = { it.uuid }) { item ->
            CompareUIItem(
                composeActivity = item.composeActivity,
                androidUIActivity = item.androidUIActivity,
                headline = item.headline
            )
        }
    }
}


@Preview(showBackground = true, device = NEXUS_6, showSystemUi = true)
@Composable
private fun MenuPreview() {
    DemoTheme {
//        Menu(state)
    }
}

