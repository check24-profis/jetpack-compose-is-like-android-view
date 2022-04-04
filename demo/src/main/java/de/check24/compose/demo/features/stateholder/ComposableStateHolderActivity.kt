package de.check24.compose.demo.features.stateholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.check24.compose.demo.theme.Blue200
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Green200

class ComposableStateHolderActivity : ComponentActivity() {

    private var myStateHolder: MyStateHolder = MyStateHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text = "State Holder") })
                    }
                ) {
                    MyScreen(stateHolder = myStateHolder)
                }
            }
        }
    }
}

class MyStateHolder() {
    // states
    var text by mutableStateOf("")
    var isClicked by mutableStateOf(false)

    // events
    fun onTextChanged(newText: String) {
        text = newText
    }
    fun onToggle(clicked: Boolean) {
        isClicked = clicked
    }
}

@Composable
private fun RememberMyStateHolder(
    text: MutableState<String>,
    isClicked: MutableState<Boolean>
) {
    // todo why don't we use just the function instead of creating another class which is given to the function? @Florian Taute
}

@Composable
fun MyScreen() {

    val stateHolder = RememberMyStateHolder()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = stateHolder.text,
            onValueChange = { stateHolder.onTextChanged(it) },
        )

        Switch(
            checked = stateHolder.isClicked,
            onCheckedChange = { stateHolder.onToggle(it) }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    if (stateHolder.isClicked) Green200 else Blue200
                )
        )
    }
}