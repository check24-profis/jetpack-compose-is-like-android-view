package de.check24.compose.demo.features.events

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
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.theme.Green200
import de.check24.compose.demo.theme.White

class ComposableEventsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Events") }
                    )
                }
            ) {
                EventsExample()
            }
        }
    }
}

// brief explanation, states are given by the parents to the children.
// The children, on the other hand, only give events to the parents.
// Thus we have a unidirectional flow.

@Composable
private fun EventsExample() {
    // this is the parent class
    // it contains the child and gives down the states
    // ideally only the parent changes the states
    var number by remember { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // here it gives the states to the child
        NumberText(number = number.toString())

        // between the curly brackets, the parent can decide what should happen when an event occurs.
        AddButton {
            number++
        }

        SubtractButton {
            number--
        }
    }

}

@Composable
private fun NumberText(number: String) {
    // the child can't change the state, in this case number.
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Green200),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // the number displayed depends on the state
            text = number,
            fontSize = 24.sp,
            color = White
        )
    }
}

@Composable
private fun AddButton(onClick: () -> Unit) {
    // if the child is clicked, an event is sent to the parents.
    Button(
        onClick = onClick,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "ADD +1")
    }
}

@Composable
private fun SubtractButton(onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Text(text = "ADD -1")
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun EventsExamplePreview() {
    EventsExample()
}