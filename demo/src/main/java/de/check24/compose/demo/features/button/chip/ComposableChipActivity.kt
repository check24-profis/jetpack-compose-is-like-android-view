package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.theme.DemoTheme

class ComposableChipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Chip ") }
                        )
                    },
                    content = {
                        ChipExample()
                    }
                )
            }
        }
    }
}

/* there is an official implementation of the chip in 1.2.0-alpha02 */

@Composable
private fun ChipExample() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(241, 255, 250)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionChip()
//        Spacer(modifier = Modifier.padding(20.dp))
        ChipWithConstantIcon()
//        Spacer(modifier = Modifier.padding(20.dp))
        ChipWithInconstantIcon()
    }
}

@Composable
fun ActionChip(
    name: String = "Action Chip",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) MaterialTheme.colors.primary else Color(68, 44, 46),
    ) {
        Row(
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    )
            )
        }
    }
}

@Composable
fun OutlinedActionChip(
    name: String = "Action Chip",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) MaterialTheme.colors.primary else Color.LightGray,
    ) {
        Row(
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    )
            )
        }
    }
}

@Composable
fun ChipWithConstantIcon(name: String = "I am a Chip") {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) Color(69, 69, 69) else Color(241, 255, 250),
        border = BorderStroke(width = 2.dp, Color(69, 69, 69))

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.padding(
                    start = 8.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            )
            Icon(
                Icons.Filled.Add,
                "",
                tint = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.padding(
                    end = 8.dp,
                )
            )
        }
    }
}

@Composable
private fun ChipWithInconstantIcon(name: String = "I am a Chip") {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) Color(69, 69, 69) else Color(241, 255, 250),
        border = BorderStroke(width = 2.dp, Color(69, 69, 69))

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.padding(8.dp)
            )
            if (isSelected) {
                Icon(
                    Icons.Filled.Check,
                    "",
                    tint = if (isSelected) Color.White else Color.Black,
                    modifier = Modifier.padding(
                        end = 8.dp,
                    )
                )
            }
        }
    }
}

/*@Composable
private fun Chip() {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .toggleable(
                value = false,
                onValueChange = { }
            )
    ) {
        Text(
            text = "I'm a chip",
            modifier = Modifier.padding(10.dp)
        )
    }
}*/

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ChipPreview() {
    DemoTheme {
        ChipExample()
    }
}