/* At the time of the implementation there were no official implementation!
* Look if there is an official implementaion already*/

// through row we get a riddle effect over the Text with padding
Row(
    modifier = Modifier
        .background(Color.LightGray)
        .toggleable(
            value = false,
            onValueChange = { }
        )
) {
    Text(
        text = "I'm a chip",
        modifier = Modifier.padding(10.dp)
    )
}