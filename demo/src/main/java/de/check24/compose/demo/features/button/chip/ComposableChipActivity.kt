package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocationAlt
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.R
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionChip()
//        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedActionChip()

        ChipWithIcon()

        InputChip()
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
        color = if (isSelected) colorResource(id = R.color.purple_100) else colorResource(id = R.color.gray_300),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                color = if (isSelected) colorResource(id = R.color.purple_500) else colorResource(id = R.color.gray_700),
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun OutlinedActionChip(
    name: String = "Outlined Chip",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .padding(4.dp)
            .hoverable(interactionSource = MutableInteractionSource(), true),
        shape = CircleShape,
        color = if (isSelected) colorResource(id = R.color.purple_100) else Color.White,
        border = if (isSelected)
            BorderStroke(width = 1.dp, colorResource(id = R.color.purple_200)) else {
            BorderStroke(width = 1.dp, colorResource(id = R.color.gray_400))
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Text(
                text = name,
                color = if (isSelected) colorResource(id = R.color.purple_500) else colorResource(id = R.color.gray_800),
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun ChipWithIcon(
    name: String = "Chip With Icon",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) colorResource(id = R.color.purple_100) else colorResource(id = R.color.gray_300),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(32.dp)
                .toggleable(
                    value = isSelected,
                    onValueChange = { isSelected = !isSelected }
                )
        ) {
            Icon(
                Icons.Default.Circle,
                "",
                tint = if (isSelected) colorResource(id = R.color.green) else Color.Red,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(24.dp)
            )
            Text(
                text = name,
                color = if (isSelected) colorResource(id = R.color.purple_500) else colorResource(id = R.color.gray_700),
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        end = 12.dp
                    )
            )
        }
    }
}

@Composable
fun InputChip(name: String = "Input Chip") {
    var isVisible by remember { mutableStateOf(true)}

    if (isVisible) {
        Surface(
            modifier = Modifier.padding(4.dp),
            shape = CircleShape,
            color = colorResource(id = R.color.gray_300),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(32.dp)
                    .toggleable(
                        value = true,
                        onValueChange = { }
                    )
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    "",
                    tint = colorResource(id = R.color.gray_700),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .width(24.dp)
                )
                Text(
                    text = name,
                    color = colorResource(id = R.color.gray_700),
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Icon(
                    Icons.Filled.Cancel,
                    "",
                    tint = colorResource(id = R.color.gray_700),
                    modifier = Modifier
                        .clickable { isVisible = !isVisible }
                        .padding(
                            start = 4.dp,
                            end = 8.dp
                        )
                        .width(18.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ChipPreview() {
    DemoTheme {
        ChipExample()
    }
}