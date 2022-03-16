package de.check24.compose.demo.features.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Shapes

class ComposableCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar {
                            Text(text = "Card")
                        }
                    },
                    content = {
                        CardExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun CardExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = 10.dp,
            shape = CircleShape

        ) {
            Text(
                text = "Card with Elevation and CircleShape",
                modifier = Modifier.padding(15.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Card with rounded corners and no elevation",
                modifier = Modifier.padding(15.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = 10.dp,
            backgroundColor = Color.LightGray
        ) {
            Text(
                text = "Card with color",
                modifier = Modifier.padding(15.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = 10.dp,
            border = BorderStroke(1.dp, Color.Green)
        ) {
            Text(
                text = "Card with a border",
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun CardPreview() {
    DemoTheme {
        CardExample()
    }
}