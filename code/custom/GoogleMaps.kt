@Composable
fun GoogleMapExample() {
    val c24Berlin = LatLng(52.51119997328961, 13.404559796099809)
    val zoom = 17F

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = CameraPositionState(
            position = CameraPosition(c24Berlin, zoom, 0F, 0F)
        )
    )
}