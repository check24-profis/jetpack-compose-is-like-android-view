package de.check24.compose.demo.features.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import de.check24.compose.demo.R
import de.check24.compose.demo.theme.DemoTheme

class ComposableToggleButtonActivity : ComponentActivity() {
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Toggle Button")
                            }
                        )
                    }, content = {
                        ToggleButtonExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun ToggleButtonExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {

            val isToggleButtonChecked = remember {
                mutableStateOf(false)
            }

            IconToggleButton(
                modifier = Modifier.wrapContentSize(),
                checked = isToggleButtonChecked.value,
                onCheckedChange = { isToggleButtonChecked.value = !isToggleButtonChecked.value },
            ) {
                val color by animateColorAsState(
                    if (isToggleButtonChecked.value) {
                        Color.Green
                    } else Color.Red
                )
                Icon(
                    Icons.Filled.Check,
                    "",
                    tint = color
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
        ) {

            val buttonClicked: MutableState<Boolean> = remember {
                mutableStateOf(false)
            }

            val buttonText: String
            val buttonTextColor: Color
            val buttonBackgroundColor: Color

            if (buttonClicked.value) {
                buttonText = "On"
                buttonTextColor = Color.Green
                buttonBackgroundColor = Color.LightGray
            } else {
                buttonText = "Off"
                buttonTextColor = Color.Red
                buttonBackgroundColor = Color.Gray
            }

            Button(
                onClick = { buttonClicked.value = !buttonClicked.value },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonBackgroundColor)
            ) {
                Text(text = buttonText, color = buttonTextColor)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ToggleButtonPreview() {
    DemoTheme {
        ToggleButtonExample()
    }
}