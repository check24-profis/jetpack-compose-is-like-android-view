package de.check24.compose.demo.features.picker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import de.check24.compose.demo.theme.DemoTheme

class ComposableTimeActivity : AppCompatActivity() {
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContent {
            DemoTheme {
                /*Scaffold(
                    topBar = {
                        TopAppBar {
                            Text(text = "Time")
                        }
                    },
                    content = { TimeExample() }
                )*/
                TimeExample()
            }
        }
        supportActionBar?.title = "Time"
    }
}

@Composable
private fun TimeExample() {

    var timePicked: String by remember {
        mutableStateOf("Pick a Time")
    }
    val updatedTime = { time: String ->
        timePicked = time
    }

    val activity = LocalContext.current as AppCompatActivity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = timePicked,
                modifier = Modifier
                    .clickable { showTimePicker(updatedTime, activity) },
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

private fun showTimePicker(
    time: (String) -> Unit,
    activity: AppCompatActivity
) {
    val picker = MaterialTimePicker.Builder()
        .setTimeFormat(TimeFormat.CLOCK_24H)
        .build()

    picker.show(activity.supportFragmentManager, picker.toString())

    picker.addOnPositiveButtonClickListener {
        time(
            correctsTime(
                picker.hour,
                picker.minute
            )
        )
    }
}

private fun correctsTime(hour: Int, minute: Int): String {
    var stringHour = hour.toString()
    var stringMinute = minute.toString()

    if (hour < 10) stringHour = "0$stringHour"
    if (minute < 10) stringMinute = "0$stringMinute"
    return "Time: $stringHour:$stringMinute"
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun TimePreview() {
    DemoTheme {
        TimeExample()
    }
}