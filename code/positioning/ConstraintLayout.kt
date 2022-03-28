ConstraintLayout(
modifier = Modifier.fillMaxSize()
) {
    val (purple, orange, blue, green, leftView, middleView, rightView) = createRefs()
    val chainRefOne = createHorizontalChain(green, blue, chainStyle = ChainStyle.Spread)
    val chainRefTwo = createHorizontalChain(leftView, middleView, rightView, chainStyle = ChainStyle.Spread)

    Text(
        textAlign = TextAlign.Center,
        text = "constraint to start, top and end of parent with a horizontal bias of 30/70",
        modifier = Modifier
            .padding(top = 80.dp)
            .width(150.dp)
            .background(Purple200)
            .padding(10.dp)
            .constrainAs(purple) {
                linkTo(
                    parent.start,
                    parent.end,
                    bias = 0.3F
                )
            }
    )

    Text(
        textAlign = TextAlign.Center,
        text = "constraint via circle radius(110dp) and angle(135) to purple",
        modifier = Modifier
            .width(300.dp)
            .background(Orange200)
            .padding(10.dp)
            .constrainAs(orange) {
                circular(ConstrainedLayoutReference(purple), angle = 0.2F, distance = 110.dp)
            }
    )

    Text(
        textAlign = TextAlign.Center,
        text = "Chain A, both are bi-directional connected",
        modifier = Modifier
            .width(120.dp)
            .background(Green200)
            .padding(10.dp)
            .constrainAs(green) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
    )

    Text(
        textAlign = TextAlign.Center,
        text = "Chain B, and chained with chainStyle \"Spread\"",
        modifier = Modifier
            .width(120.dp)
            .background(Blue200)
            .padding(10.dp)
            .constrainAs(blue) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
    )

    Text(
        textAlign = TextAlign.Center,
        text = "chained with 30 percent",
        modifier = Modifier
            .background(Red200)
            .padding(10.dp)
            .height(60.dp)
            .constrainAs(leftView) {
                bottom.linkTo(parent.bottom)
                width = Dimension.percent(0.3F)
            }
    )

    Text(
        text = "chained with 40 percent",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Gray)
            .padding(10.dp)
            .height(60.dp)
            .constrainAs(middleView) {
                bottom.linkTo(parent.bottom)
                width = Dimension.percent(0.4F)
            }
    )

    Text(
        textAlign = TextAlign.Center,
        text = "chained with 30 percent",
        modifier = Modifier
            .background(Color.Cyan)
            .padding(10.dp)
            .height(60.dp)
            .constrainAs(rightView) {
                bottom.linkTo(parent.bottom)
                width = Dimension.percent(0.3F)
            }
    )
}