@Composable
fun ConstraintLayoutGroup(
    groupModifier: Modifier
) {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (text1, text2) = createRefs()

        Text(
            text = "text1",
            modifier = groupModifier.then(
                Modifier.constrainAs(text1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )
        )

        Text(
            text = "text2",
            modifier = groupModifier.then(
                Modifier.constrainAs(text2) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )
        )
    }
}