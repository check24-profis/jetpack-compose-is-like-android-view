package de.check24.compose.demo.features.bundle

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Purple200
import kotlinx.parcelize.Parcelize

class ComposableBundleObjectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Bundle Objects") })
                    }
                ) {
                    BundleObjectsExample()
                }
            }
        }
    }
}

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

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun BundleObjectsExamplePreview() {
    DemoTheme {
        BundleObjectsExample()
    }
}