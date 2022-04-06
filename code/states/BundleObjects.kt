// bundle with Parcelize
@Parcelize
data class Person(val name: String, val lastname: String) : Parcelable

// bundle with MapSaver
data class River(val name: String, val country: String)

val RiverMapSaver = run {
    val nameKey = "River name"
    val countryKey = "Country"
    mapSaver(
        save = { mapOf(nameKey to it.name, countryKey to it.country) },
        restore = { River(it[nameKey] as String, it[countryKey] as String) }
    )
}

// bundle with ListSaver
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
        NameText(person = person)

        // MapSaver
        val riverMapSaver = rememberSaveable(stateSaver = RiverMapSaver) {
            mutableStateOf(River(name = "Spree", country = "Germany"))
        }
        RiverText(riverMapSaver)

        // ListSaver
        val riverListSaver = rememberSaveable(stateSaver = RiverListSaver) {
            mutableStateOf(River(name = "Ishikari", country = "Japan"))
        }
        RiverText(river = riverListSaver)
    }
}

@Composable
private fun NameText(person: Person) {
    Text(
        text = "My name is " + person.name + " " + person.lastname,
        modifier = Modifier
            .width(200.dp)
            .background(Purple200),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun RiverText(river: MutableState<River>) {
    Text(
        text = river.value.name + " is in " + river.value.country,
        modifier = Modifier
            .width(200.dp)
            .background(Purple200),
        textAlign = TextAlign.Center
    )
}