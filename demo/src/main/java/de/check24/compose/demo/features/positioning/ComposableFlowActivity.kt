package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Purple200

class ComposableFlowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Flow") }
                        )
                    },
                    content = {
                        FlowExample()
                    }
                )
            }
        }
    }
}

val textList = listOf(
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten"
)

@Composable
private fun FlowExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FlowColumn(
            modifier = Modifier
                .height(300.dp)
                .wrapContentWidth(),
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            mainAxisSpacing = 16.dp,
            crossAxisSpacing = 50.dp,
            crossAxisAlignment = FlowCrossAxisAlignment.Center,
        ) {
            TextViews(textList = textList)
        }

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp),
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            crossAxisSpacing = 16.dp,
            mainAxisSpacing = 16.dp
        ) {
            TextViews(textList = textList)
        }
    }
}

@Composable
private fun TextViews(textList: List<String>) {
    textList.forEach {
        Text(
            text = it,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Purple200)
                .padding(10.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun FlowExamplePreview() {
    DemoTheme {
        FlowExample()
    }
}