// bundle with Parcelize
// here we bundle the full name of a person
@Parcelize
data class Person(val name: String, val lastname: String) : Parcelable

// bundle with MapSaver
// here we bundle the name of a river and the country where it's located
data class River(val name: String, val country: String)

// here we create the bundle with a MapSaver
// and assign our river data class to it
val RiverMapSaver = run {
    val nameKey = "River name"
    val countryKey = "Country"
    mapSaver(
        save = { mapOf(nameKey to it.name, countryKey to it.country) },
        restore = { River(it[nameKey] as String, it[countryKey] as String) }
    )
}

// here we create the bundle with a ListSaver
// and assign our river data class to it
val RiverListSaver = listSaver<River, Any>(
    save = { listOf(it.name, it.country) },
    restore = { River(name = it[0] as String, country = it[1] as String) }
)

@Composable
private fun BundleObjectsExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Parcelable
        val person = Person(name = "John", lastname = "Cole")
        NameText(personPlaceable = person)

        // MapSaver
        val riverMapSaver = rememberSaveable(stateSaver = RiverMapSaver) {
            mutableStateOf(River(name = "Spree", country = "Germany"))
        }
        RiverText(riverMapSaver.value)

        // ListSaver
        val riverListSaver = rememberSaveable(stateSaver = RiverListSaver) {
            mutableStateOf(River(name = "Ishikari", country = "Japan"))
        }
        RiverText(riverSaver = riverListSaver.value)
    }
}

@Composable
private fun NameText(personPlaceable: Person) {
    Text(
        text = "My name is " + personPlaceable.name + " " + personPlaceable.lastname,
        modifier = Modifier
            .width(200.dp)
            .background(Purple200),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun RiverText(riverSaver: River) {
    Text(
        text = riverSaver.name + " is in " + riverSaver.country,
        modifier = Modifier
            .width(200.dp)
            .background(Purple200),
        textAlign = TextAlign.Center
    )
}