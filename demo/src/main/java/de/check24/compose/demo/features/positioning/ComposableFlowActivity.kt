package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200
import de.check24.compose.demo.theme.Orange200
import de.check24.compose.demo.theme.Red200

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

@Composable
private fun FlowExample() {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (verticalFlow, horizontalFlow) = createRefs()

        FlowColumn(
            modifier = Modifier
                .height(300.dp)
                .wrapContentWidth()
                .constrainAs(verticalFlow) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(horizontalFlow.top)
                },
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            mainAxisSpacing = 16.dp,
            crossAxisSpacing = 50.dp,
            crossAxisAlignment = FlowCrossAxisAlignment.Center,
        ) {
            TextViews()
        }

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp)
                .constrainAs(horizontalFlow) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(verticalFlow.bottom)
                    bottom.linkTo(parent.bottom)
                },
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            crossAxisSpacing = 16.dp,
            mainAxisSpacing = 16.dp
        ) {
            TextViews()
        }
    }

}

@Composable
private fun TextViews() {
    val colorList = listOf(
        Red200,
        Orange200,
        Green200,
        Blue200
    )

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

    var colorIterator = 0

    for (i in 0..9) {
        Text(
            modifier = Modifier
                .background(colorList[colorIterator])
                .padding(10.dp),
            text = textList[i],
            textAlign = TextAlign.Center
        )
        colorIterator++
        if (colorIterator >= 4) colorIterator = 0
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun FlowExamplePreview() {
    DemoTheme {
        FlowExample()
    }
}