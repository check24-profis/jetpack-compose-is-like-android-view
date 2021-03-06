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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
private fun ChipExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionChip()
        OutlinedActionChip()
        ActionChip("Chip With Icon", icon = rememberVectorPainter(image = Icons.Default.Circle))
        InputChip(icon = rememberVectorPainter(image = Icons.Default.MyLocation))
        ChipWithToggleIcon()
    }
}

@Composable
fun ActionChip(
    name: String = "Action Chip",
    icon: Painter? = null,
    onToggle: ((String) -> Unit)? = null
) {
    var isSelected by remember { mutableStateOf(false) }
    val modifier = if (icon == null) {
        Modifier.padding(horizontal = 12.dp)
    } else Modifier.padding(start = 4.dp, end = 12.dp)

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
                    onValueChange = {
                        isSelected = !isSelected
                        onToggle?.invoke(name)
                    }
                )
        ) {
            if (icon != null) {
                Icon(
                    icon,
                    "",
                    tint = if (isSelected) Green else Red,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .width(24.dp)
                )
            }

            Text(
                text = name,
                color = if (isSelected) Purple500 else Gray700,
                style = MaterialTheme.typography.body2,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun OutlinedActionChip(
    name: String = "Outlined Chip",
    onToggle: ((String) -> Unit)? = null
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
                    onValueChange = {
                        isSelected = !isSelected
                        onToggle?.invoke(name)
                    }
                )
        ) {
            Text(
                text = name,
                color = if (isSelected) Purple500 else Gray800,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun InputChip(
    name: String = "Input Chip",
    icon: Painter? = null,
) {

    var isVisible by remember { mutableStateOf(true) }
    val modifier = if (icon == null) {
        Modifier.padding(start = 12.dp, end = 4.dp)
    } else Modifier.padding(horizontal = 4.dp)

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
                if (icon != null) {
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
                    style = MaterialTheme.typography.body2,
                    modifier = modifier
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
    icon: Painter = rememberVectorPainter(image = Icons.Default.Check),
    onToggle: ((String) -> Unit)? = null
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
                    onValueChange = {
                        isSelected = !isSelected
                        onToggle?.invoke(name)
                    }
                )
        ) {
            if (isSelected) {
                Icon(
                    icon,
                    "",
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .width(24.dp)
                )
            }
            Text(
                text = name,
                color = if (isSelected) Gray800 else Gray700,
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

@Composable
fun ActionChipSingleSelection(
    selectedChip: String,
    currentItem: String,
    onToggle: (String) -> Unit
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = if (selectedChip == currentItem) {
            colorResource(id = R.color.purple_100)
        } else colorResource(id = R.color.gray_300)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(32.dp)
                .clickable {
                    onToggle(currentItem)
                }
        ) {
            Text(
                text = currentItem,
                color = if (selectedChip == currentItem) colorResource(id = R.color.purple_500) else colorResource(
                    id = R.color.gray_700
                ),
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 12.dp)
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

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun ActionChipPreview() {
    DemoTheme {
        ActionChip()
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun InputChipPreview() {
    DemoTheme {
        InputChip()
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun OutlinedChipPreview() {
    DemoTheme {
        OutlinedActionChip()
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun ToggleChipPreview() {
    DemoTheme {
        ChipWithToggleIcon()
    }
}