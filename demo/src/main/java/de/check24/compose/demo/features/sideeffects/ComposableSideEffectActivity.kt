package de.check24.compose.demo.features.sideeffects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200

class ComposableSideEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "SideEffect") }
                        )
                    }
                ) {
                    SideEffectExample()
                }
            }
        }
    }
}

/*  the SideEffect is used when you only want to run code if the composable is successfully recomposed
    this is for example useful if you want to make a sever request. Then you only make a request if
    your composable is successfully recomposed.*/

@Composable
private fun SideEffectExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "With SideEffect")
        WithSideEffect()
        Text(text = "Without SideEffect")
        WithoutSideEffect()
    }
}

@Composable
private fun WithoutSideEffect() {
    var timer by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp)
            .background(Green200),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$timer",
        )
    }

    Thread.sleep(1000)
    timer++
}

@Composable
private fun WithSideEffect() {
    var timer by remember {
        mutableStateOf(0)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp)
            .background(Green200),
    ) {
        Text(
            text = "$timer",
        )
    }

    SideEffect {
        Thread.sleep(1000)
        timer++
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun SideEffectExamplePreview() {
    DemoTheme {
        SideEffectExample()
    }
}