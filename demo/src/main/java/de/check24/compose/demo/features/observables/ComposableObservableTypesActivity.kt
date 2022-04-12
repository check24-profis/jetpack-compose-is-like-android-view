package de.check24.compose.demo.features.observables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200
import kotlinx.coroutines.flow.MutableStateFlow

class ComposableObservableTypesActivity : ComponentActivity() {

    private val model = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "Observable types") })
                    }
                ) {
                    ObservableTypeExample(model)
                }
            }
        }
    }
}

class MyViewModel : ViewModel() {
    var isSelected = MutableStateFlow(false)
    var text = MutableLiveData<String>()

    fun onToggle() {
        isSelected.value = !isSelected.value
    }

    fun onValueChanged(input: String) {
        text.value = input
    }
}

@Composable
private fun ObservableTypeExample(model: MyViewModel) {
    val text: String by model.text.observeAsState("")
    val isClicked: Boolean by model.isSelected.collectAsState()

    MyScreen(
        text = text,
        isClicked = isClicked,
        onValueChanged = { model.onValueChanged(it) },
        onToggle = { model.onToggle() }
    )
}

@Composable
fun MyScreen(
    text: String,
    isClicked: Boolean,
    onValueChanged: (String) -> Unit,
    onToggle: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { onValueChanged(it) },
        )

        Switch(
            checked = isClicked,
            onCheckedChange = { onToggle() }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (isClicked) Green200 else Blue200
                )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun ObservableTypeExamplePreview() {
    DemoTheme {
        val model = MyViewModel()
        ObservableTypeExample(model)
    }
}