package de.check24.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.NEXUS_6
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.check24.demo.extensions.findActivity
import de.check24.demo.features.password.AndroidUIPasswordActivity
import de.check24.demo.features.password.ComposablePasswordActivity
import de.check24.demo.features.password.visibility.AndroidUIPasswordVisibilityToggleActivity
import de.check24.demo.features.password.visibility.ComposablePasswordVisibilityToggleActivity
import de.check24.demo.features.text.AndroidUITextActivity
import de.check24.demo.features.text.ComposableTextActivity
import de.check24.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Menu()
                }
            }
        }
    }
}

@Composable
private fun Menu() {
    Column {

        Row {
            CompareUIItem(
                composeActivity = ComposableTextActivity::class.java,
                androidUIActivity = AndroidUITextActivity::class.java,
                headline = "Plain Text"
            )
        }


        Row {
            CompareUIItem(
                composeActivity = ComposablePasswordActivity::class.java,
                androidUIActivity = AndroidUIPasswordActivity::class.java,
                headline = "Password"
            )
        }
        Row {
            CompareUIItem(
                composeActivity = ComposablePasswordVisibilityToggleActivity::class.java,
                androidUIActivity = AndroidUIPasswordVisibilityToggleActivity::class.java,
                headline = "Password with visibility toggle"
            )
        }
    }
}

@Composable
private fun <T, P : Activity> CompareUIItem(
    composeActivity: Class<T>,
    androidUIActivity: Class<P>,
    headline: String
) {
    val activity = LocalContext.current.findActivity()

    Column(
        modifier = Modifier.padding(4.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = headline,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                activity?.startActivity(
                    Intent(
                        activity,
                        composeActivity
                    )
                )
            }) { Text(text = "Compose") }


            Button(onClick = {
                activity?.startActivity(
                    Intent(
                        activity,
                        androidUIActivity
                    )
                )
            }) { Text(text = "Android UI") }
        }
        Divider(
            color = Color.Black,
            thickness = 1.dp
        )
    }
}

@Preview(showBackground = true, device = NEXUS_6, showSystemUi = true)
@Composable
private fun MenuPreview() {
    DemoTheme {
        Menu()
    }
}

@Preview(showBackground = true, device = NEXUS_6, showSystemUi = true)
@Composable
private fun GenericItemPreview() {
    DemoTheme {
        CompareUIItem(ComposableTextActivity::class.java, ComposableTextActivity::class.java, "Test")
    }
}
