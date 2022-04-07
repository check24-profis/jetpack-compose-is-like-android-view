package de.check24.compose.demo.features.constraintlayout.flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import de.check24.compose.demo.features.button.chip.ActionChip
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200
import de.check24.compose.demo.theme.Orange200
import de.check24.compose.demo.theme.Red200
import de.check24.compose.demo.theme.Teal200

class ComposableHelperFlowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Helper (Flow)") }
                        )
                    }
                ) {
                    HelperFlowExample()
                }
            }
        }
    }
}

@Composable
private fun HelperFlowExample() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val (flowView, flowOptions) = createRefs()

        var sizeMode by remember {
            mutableStateOf(SizeMode.Wrap)
        }
        var mainAxisAlignment by remember {
            mutableStateOf(FlowMainAxisAlignment.Center)
        }
        var crossAxisAlignment by remember {
            mutableStateOf(FlowCrossAxisAlignment.Center)
        }
        var isSelectedVerticalChip by remember {
            mutableStateOf(false)
        }
        var isSelectedHorizontalChip by remember {
            mutableStateOf(false)
        }
        var mainAxisSpacing by remember {
            mutableStateOf(0.dp)
        }
        var crossAxisSpacing by remember {
            mutableStateOf(0.dp)
        }

        FlowRow(
            mainAxisSize = sizeMode,
            mainAxisAlignment = mainAxisAlignment,
            crossAxisAlignment = crossAxisAlignment,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(flowView) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(flowOptions.top)
                },
            mainAxisSpacing = mainAxisSpacing,
            crossAxisSpacing = crossAxisSpacing
        ) {
            ColorBox(number = "1", Blue200)
            ColorBox(number = "2", Green200)
            ColorBox(number = "3", Orange200)
            ColorBox(number = "4", Red200)
            ColorBox(number = "5", Teal200)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(flowOptions) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            FlowStyleAndWrapMode("sizeMode", listOf("Wrap", "Expand")) {
                sizeMode = getSizeMode(it)
            }

            FlowStyleAndWrapMode(
                "mainAxisAlignment",
                listOf("Center", "SpaceBetween", "End", "Start", "SpaceAround", "SpaceEvenly")
            ) {
                mainAxisAlignment = getMainAxisAlignment(it)
            }

            FlowStyleAndWrapMode("crossAxisAlignment", listOf("Center", "End", "Start")) {
                crossAxisAlignment = getCrossAxisAlignment(it)
            }

            ItemSpacing(
                onToggleHorizontalSpace = {
                    isSelectedHorizontalChip = !isSelectedHorizontalChip
                    mainAxisSpacing = (if (isSelectedHorizontalChip) 20.dp else 0.dp)
                },
                onToggleVerticalSpace = {
                    isSelectedVerticalChip = !isSelectedVerticalChip
                    crossAxisSpacing = (if (isSelectedVerticalChip) 20.dp else 0.dp)
                }
            )
        }
    }
}

private fun getSizeMode(alignment: String): SizeMode {
    return when (alignment) {
        "Wrap" -> SizeMode.Wrap
        "Expand" -> SizeMode.Expand
        else -> {
            SizeMode.Wrap
        }
    }
}

private fun getMainAxisAlignment(alignment: String): FlowMainAxisAlignment {
    return when (alignment) {
        "Center" -> FlowMainAxisAlignment.Center
        "Start" -> FlowMainAxisAlignment.Start
        "End" -> FlowMainAxisAlignment.End
        "SpaceBetween" -> FlowMainAxisAlignment.SpaceBetween
        "SpaceAround" -> FlowMainAxisAlignment.SpaceAround
        "SpaceEvenly" -> FlowMainAxisAlignment.SpaceEvenly
        else -> {
            FlowMainAxisAlignment.Center
        }
    }
}

private fun getCrossAxisAlignment(alignment: String): FlowCrossAxisAlignment {
    return when (alignment) {
        "Center" -> FlowCrossAxisAlignment.Center
        "Start" -> FlowCrossAxisAlignment.Start
        "End" -> FlowCrossAxisAlignment.End
        else -> {
            FlowCrossAxisAlignment.Center
        }
    }
}

@Composable
private fun ItemSpacing(onToggleVerticalSpace: () -> Unit, onToggleHorizontalSpace: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ActionChip(name = "vertical Space") {
            onToggleVerticalSpace()
        }
        ActionChip(name = "horizontal Space") {
            onToggleHorizontalSpace()
        }
    }
}

@Composable
private fun FlowStyleAndWrapMode(text: String, list: List<String>, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 18.sp
        )
        Spinner(list) {
            onClick(it)
        }
    }
}

@Composable
private fun Spinner(list: List<String>, onClick: (String) -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    var string by remember { mutableStateOf(list[0]) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = string, Modifier.clickable { expanded = !expanded })
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "DropDown Arrow")
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach { item ->

                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        string = item
                        onClick(string)
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}

@Composable
private fun ColorBox(number: String, color: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = number,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = Color.White
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun HelperFlowExamplePreview() {
    DemoTheme {
        HelperFlowExample()
    }
}