package de.check24.compose.demo

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.compose.demo.extensions.findActivity
import de.check24.compose.demo.features.text.ComposableTextActivity
import de.check24.compose.demo.theme.DemoTheme

internal data class SingleItem(
    val activity: Class<out Activity>,
    val headline: String
)

@Composable
internal fun SingleUIItem(
    UIActivity: Class<out Activity>,
    headline: String
) {
    val activity = LocalContext.current.findActivity()

    Column(
        modifier = Modifier.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = headline,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )

        Button(onClick = {
            activity?.startActivity(
                Intent(
                    activity,
                    UIActivity
                )
            )
        }
        ) { Text(text = "Move to screen") }

        Divider(
            color = Color.Black,
            thickness = 1.dp
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun SingleUIItemPreview() {
    DemoTheme {
        SingleUIItem(
            ComposableTextActivity::class.java,
            "Test"
        )
    }
}