@Composable
fun NavHostDemo() {

    val navController = rememberNavController()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val abc = listOf("A", "B", "C")

        NavHost(navController = navController, startDestination = "A") {

            abc.forEach { letter ->

                composable(letter) {
                    Text(text = letter)
                }
            }
        }

        Row {

            abc.forEach { letter ->
                Button(onClick = { navController.navigate(letter) }) {
                    Text(text = letter)
                }
            }
        }
    }
}