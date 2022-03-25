package de.check24.compose.demo.features.button.chip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.R
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Gray300
import de.check24.compose.demo.theme.Gray400
import de.check24.compose.demo.theme.Gray700
import de.check24.compose.demo.theme.Gray800
import de.check24.compose.demo.theme.Green
import de.check24.compose.demo.theme.Purple100
import de.check24.compose.demo.theme.Purple200
import de.check24.compose.demo.theme.Purple500
import de.check24.compose.demo.theme.Red
import de.check24.compose.demo.theme.White

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
        OutlinedActionChip()
        ChipWithIcon()
        InputChip(iconEnabled = true)
        ChipWithToggleIcon()
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
        color = if (isSelected) Purple100 else Gray300,
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
                color = if (isSelected) Purple500 else Gray700,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
private fun OutlinedActionChip(
    name: String = "Outlined Chip",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .padding(4.dp)
            .hoverable(interactionSource = MutableInteractionSource(), true),
        shape = CircleShape,
        color = if (isSelected) Purple100 else White,
        border = if (isSelected)
            BorderStroke(width = 1.dp, Purple200) else {
            BorderStroke(width = 1.dp, Gray400)
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
                color = if (isSelected) Purple500 else Gray800,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
private fun ChipWithIcon(
    name: String = "Chip With Icon",
    icon: ImageVector = Icons.Default.Circle
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) Purple100 else Gray300,
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
                icon,
                "",
                tint = if (isSelected) Green else Red,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(24.dp)
            )
            Text(
                text = name,
                color = if (isSelected) Purple500 else Gray700,
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
fun InputChip(
    name: String = "Input Chip",
    icon: ImageVector = Icons.Default.MyLocation,
    iconEnabled: Boolean
) {

    var isVisible by remember { mutableStateOf(true) }

    if (isVisible) {
        Surface(
            modifier = Modifier.padding(4.dp),
            shape = CircleShape,
            color = Gray300,
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
                if (iconEnabled) {
                    Icon(
                        icon,
                        "",
                        tint = Gray700,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width(24.dp)
                    )
                }
                Text(
                    text = name,
                    color = Gray700,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Icon(
                    Icons.Filled.Cancel,
                    "",
                    tint = Gray700,
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

@Composable
private fun ChipWithToggleIcon(
    name: String = "Chip With toggleable Icon",
) {
    var isSelected by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (isSelected) Gray400 else Gray300,
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
            AnimatedVisibility(
                visible = isSelected,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()
            ) {
                Icon(
                    Icons.Default.Check,
                    "",
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .width(24.dp)
                )
            }
            Text(
                text = name,
                color = if (isSelected) Gray800 else Gray700,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 12.dp
                    )
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun ChipPreview() {
    DemoTheme {
        ChipExample()
    }
}