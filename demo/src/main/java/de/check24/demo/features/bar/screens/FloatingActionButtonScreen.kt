package de.check24.demo.features.bar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatingActionButtonScreen () {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "FloatingActionButton Screen",
            Modifier.background(Color.Gray)
        )
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4, showBackground = true)
@Composable
private fun FloatingActionButtonScreenPreview() {
    FloatingActionButtonScreen()
}