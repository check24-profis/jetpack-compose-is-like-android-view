@Composable
fun ConstraintLayoutBarrier() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (text1, text2, button) = createRefs()

        Text(
            text = "text1",
            modifier = Modifier
                .constrainAs(text1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .height(200.dp)
                .wrapContentWidth()
        )

        Text(
            text = "text2",
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .wrapContentHeight()
                .wrapContentWidth()
        )

        val barrier = createBottomBarrier(text1, text2)

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(barrier)
                start.linkTo(parent.start)
            }
        ) {
            Text("Button")
        }
    }
}
