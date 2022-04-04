package de.check24.compose.demo.features.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200

class ComposableViewModelActivity : ComponentActivity() {

    private val myViewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "ViewModel") })
                    }
                ) {
                    MyScreen(myViewModel = myViewModel)
                }
            }
        }
    }
}
/* the composable way */

// the ViewModel manages the states and the events
// it also has access to the business logic and lives longer than the composable
class MyViewModel : ViewModel(), IMyViewModel {
    // states
    override var text = mutableStateOf("")
    override var isClicked = mutableStateOf(false)

    // events
    override fun onTextChanged(newText: String) {
        text.value = newText
    }
    override fun onToggle(clicked: Boolean) {
        isClicked.value = clicked
    }
}

@Composable
fun MyScreen(myViewModel: MyViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = myViewModel.text.value,
            onValueChange = { myViewModel.onTextChanged(it) },
        )

        Switch(
            checked = myViewModel.isClicked.value,
            onCheckedChange = { myViewModel.onToggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (myViewModel.isClicked.value) Green200 else Blue200
                )
        )
    }
}

/* with this way the preview works */
interface IMyViewModel {
    val text: MutableState<String>
    val isClicked : MutableState<Boolean>

    fun onTextChanged(newText: String)
    fun onToggle(clicked: Boolean)
}

@Composable
//fun MyScreen(myViewModel: MyViewModel = viewModel()) {
fun MyScreen(myViewModel: IMyViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = myViewModel.text.value,
            onValueChange = { myViewModel.onTextChanged(it) },
        )

        Switch(
            checked = myViewModel.isClicked.value,
            onCheckedChange = { myViewModel.onToggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (myViewModel.isClicked.value) Green200 else Blue200
                )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ViewModelExamplePreview() {
    DemoTheme {
        val myViewModel = object:IMyViewModel{
            override val text: MutableState<String>
                get() = mutableStateOf("Hello World")
            override val isClicked: MutableState<Boolean>
                get() = mutableStateOf(false)

            override fun onTextChanged(newText: String) {
                text.value = newText
            }

            override fun onToggle(clicked: Boolean) {
                isClicked.value = clicked
            }
        }
        MyScreen(myViewModel = myViewModel)
    }
}