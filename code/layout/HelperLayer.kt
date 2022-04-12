// At the time of the implementation there was no official compose equivalent
// This is an attempt to create a helperlayer

@Composable
private fun HelperLayerExample() {

    var rotationRGB: Float by remember { mutableStateOf(0f) }
    val angleRGB: Float by animateFloatAsState(
        targetValue = rotationRGB,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
    )

    var rotationRG: Float by remember { mutableStateOf(0f) }
    val angleRG: Float by animateFloatAsState(
        targetValue = rotationRG,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
    )

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // first layer
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = angleRGB
                }
        ) {
            // second layer within the first layer
            Column(
                modifier = Modifier.graphicsLayer {
                    rotationZ = angleRG
                }
            ) {
                ColorBox(color = Red200)
                ColorBox(color = Green200)
            }
            ColorBox(color = Blue200)
        }

        Button(
            onClick = { rotationRGB += 360f }
        ) {
            Text(text = "Rotate 360°")
        }

        Button(
            onClick = { rotationRG += 360f }
        ) {
            Text(text = "Rotate Red and Green°")
        }
    }
}