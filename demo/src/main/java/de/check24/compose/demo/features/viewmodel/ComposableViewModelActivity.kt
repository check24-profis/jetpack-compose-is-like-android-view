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
    override var isSelected = mutableStateOf(false)

    // events
    override fun addNumber() {
        number.value = number.value + 1
    }

    override fun toggle(clicked: Boolean) {
        isSelected.value = clicked
    }
}

@Composable
fun MyScreen(myViewModel: MyViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(Blue200)
                .size(50.dp)
                .clickable { myViewModel.addNumber() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = myViewModel.number.value.toString()
            )
        }

        Switch(
            checked = myViewModel.isSelected.value,
            onCheckedChange = { myViewModel.toggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (myViewModel.isSelected.value) Green200 else Blue200
                )
        )
    }
}

/* the way how the preview works */
interface MyViewModelInterface {
    val number: MutableState<Int>
    val isSelected: MutableState<Boolean>

    fun addNumber()
    fun toggle(clicked: Boolean)
}

@Composable
fun MyScreen(myViewModel: MyViewModelInterface) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(Blue200)
                .size(50.dp)
                .clickable { myViewModel.addNumber() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = myViewModel.number.value.toString()
            )
        }

        Switch(
            checked = myViewModel.isSelected.value,
            onCheckedChange = { myViewModel.toggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (myViewModel.isSelected.value) Green200 else Blue200
                )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun MyScreenPreview() {
    DemoTheme {
        val myViewModel = MyViewModel()
        MyScreen(myViewModel = myViewModel)
    }
}