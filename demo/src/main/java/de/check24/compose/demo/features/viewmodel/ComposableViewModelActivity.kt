package de.check24.compose.demo.features.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
/* Google's composable way */

// the ViewModel manages the states and the events
// it also has access to the business logic and lives longer than the composable
class MyViewModel : ViewModel(), MyViewModelInterface {
    // states
    override var number = mutableStateOf(0)
    override var isClicked = mutableStateOf(false)

    // events
    override fun onClick() {
        number.value = number.value + 1
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
        Box(
            modifier = Modifier
            .background(Blue200)
            .size(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .clickable { myViewModel.onClick() },
                textAlign = TextAlign.Center,
                text = myViewModel.number.value.toString()
            )
        }

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

/* the way how the preview works */
interface MyViewModelInterface {
    val number: MutableState<Int>
    val isClicked : MutableState<Boolean>

    fun onClick()
    fun onToggle(clicked: Boolean)
}

@Composable
fun MyScreen(myViewModelInterface: MyViewModelInterface) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = myViewModelInterface.number.toString(),
            modifier = Modifier.clickable { myViewModelInterface.onClick() }
        )

        Switch(
            checked = myViewModelInterface.isClicked.value,
            onCheckedChange = { myViewModelInterface.onToggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (myViewModelInterface.isClicked.value) Green200 else Blue200
                )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ViewModelExamplePreview() {
    DemoTheme {
        val myViewModel = object:MyViewModelInterface{
            override val number: MutableState<Int>
                get() = mutableStateOf(0)
            override val isClicked: MutableState<Boolean>
                get() = mutableStateOf(false)

            override fun onClick() {
                number.value = number.value + 1
            }

            override fun onToggle(clicked: Boolean) {
                isClicked.value = clicked
            }
        }
        MyScreen(myViewModelInterface = myViewModel)
    }
}