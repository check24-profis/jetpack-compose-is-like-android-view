package de.check24.compose.demo.features.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import de.check24.compose.demo.theme.DemoTheme

class ComposableAutoCompleteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Auto Complete")
                            }
                        )
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            AutoCompleteExample()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun AutoCompleteExample() {

    val countriesList = listOf(
        "Germany",
        "Spain",
        "France",
        "Portugal",
        "Netherlands",
        "Belgium",
        "Great Britain",
        "Luxembourg",
        "Switzerland",
        "Austria",
        "Italy",
        "Poland",
        "Slovakia",
        "Czech Republic",
        "Russia"
    )

    val dropDownOptions = remember { mutableStateOf(listOf("")) }
    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }
    val dropDownExpanded = remember { mutableStateOf(false) }

    fun onDropdownDismissRequest() {
        dropDownExpanded.value = false
    }

    fun onValueChanged(value: TextFieldValue) {
        dropDownExpanded.value = true
        textFieldValue.value = value
        dropDownOptions.value =
            countriesList.filter { it.startsWith(value.text) && it != value.text }.take(3)
    }

    TextFieldWithDropdown(
        value = textFieldValue.value,
        setValue = ::onValueChanged,
        onDismissRequest = ::onDropdownDismissRequest,
        dropDownExpanded = dropDownExpanded.value,
        list = dropDownOptions.value,
    )
}

@Composable
private fun TextFieldWithDropdown(
    value: TextFieldValue,
    setValue: (TextFieldValue) -> Unit,
    onDismissRequest: () -> Unit,
    dropDownExpanded: Boolean,
    list: List<String>
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .onFocusChanged { focusState ->
                if (!focusState.isFocused)
                    onDismissRequest()
            },
        value = value,
        onValueChange = setValue,
        label = { Text("Enter a country of Europe") },
        colors = TextFieldDefaults.outlinedTextFieldColors()
    )
    DropdownMenu(
        expanded = dropDownExpanded,
        properties = PopupProperties(
            focusable = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        onDismissRequest = onDismissRequest,
    ) {
        list.forEach { text ->
            DropdownMenuItem(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClickLabel = text,
                    null
                ) {
                    setValue(
                        TextFieldValue(
                            text,
                            TextRange(text.length)
                        )
                    )
                },
                onClick = {
                    setValue(
                        TextFieldValue(
                            text,
                            TextRange(text.length)
                        )
                    )
                }
            ) {
                Text(text = text)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun AutoCompletePreview() {
    DemoTheme {
        AutoCompleteExample()
    }
}