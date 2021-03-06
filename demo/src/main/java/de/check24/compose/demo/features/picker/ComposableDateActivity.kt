package de.check24.compose.demo.features.picker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.datepicker.MaterialDatePicker
import de.check24.compose.demo.theme.DemoTheme

class ComposableDateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Date()
            }
        }
        supportActionBar?.title = "Date"
    }
}

@Composable
fun Date() {

    var datePicked: String by remember {
        mutableStateOf("Date")
    }

    val updatedDate = { date: String ->
        datePicked = date
    }

    val activity = LocalContext.current as AppCompatActivity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Text(
                text = datePicked,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { showDatePicker(activity, updatedDate) }
            )
        }
    }
}

private fun showDatePicker(
    activity: AppCompatActivity,
    updatedDate: (String) -> Unit
) {
    val picker = MaterialDatePicker.Builder.datePicker().build()

    // be careful with the datepicker, because you need to manage the dispose!
    picker.show(activity.supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        updatedDate(picker.headerText)
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun DatePreview() {
    DemoTheme {
        Date()
    }
}