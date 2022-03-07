package de.check24.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import de.check24.demo.features.button.AndroidUICheckBoxActivity
import de.check24.demo.features.button.ComposableCheckBoxActivity
import de.check24.demo.features.constraintlayout.barrier.AndroidUIBarrierActivity
import de.check24.demo.features.constraintlayout.barrier.ComposableBarrierActivity
import de.check24.demo.features.email.AndroidUIEmailActivity
import de.check24.demo.features.email.ComposableEmailActivity
import de.check24.demo.features.password.AndroidUIPasswordActivity
import de.check24.demo.features.password.ComposablePasswordActivity
import de.check24.demo.features.password.numeric.AndroidUINumericPasswordActivity
import de.check24.demo.features.password.numeric.ComposableNumericPasswordActivity
import de.check24.demo.features.password.visibility.AndroidUIPasswordVisibilityToggleActivity
import de.check24.demo.features.password.visibility.ComposablePasswordVisibilityToggleActivity
import de.check24.demo.features.phone.AndroidUIPhoneTextActivity
import de.check24.demo.features.phone.ComposablePhoneTextActivity
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

/**
 * Add [CompareUIItem] for every section here
 */
@Composable
private fun Menu() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

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
        Row {
            CompareUIItem(
                composeActivity = ComposableNumericPasswordActivity::class.java,
                androidUIActivity = AndroidUINumericPasswordActivity::class.java,
                headline = "Password (Numeric)"
            )
        }

        Row {
            CompareUIItem(
                composeActivity = ComposableEmailActivity::class.java,
                androidUIActivity = AndroidUIEmailActivity::class.java,
                headline = "Email"
            )
        }

        Row {
            CompareUIItem(
                composeActivity = ComposablePhoneTextActivity::class.java,
                androidUIActivity = AndroidUIPhoneTextActivity::class.java,
                headline = "Phone Number"
            )
        }

        Row {
            CompareUIItem(
                composeActivity = ComposableCheckBoxActivity::class.java,
                androidUIActivity = AndroidUICheckBoxActivity::class.java,
                headline = "CheckBox"
            )
        }

        Row {
            CompareUIItem(
                composeActivity = ComposableBarrierActivity::class.java,
                androidUIActivity = AndroidUIBarrierActivity::class.java,
                headline = "Constraint Layout (Barrier)"
            )
        }
    }
}

/**
 * UI Item to display a new compare section between Jetpack Compose and AndroidUI
 *
 * @param composeActivity the activity which handles the composable
 * @param androidUIActivity the activity which handles the AndroidUI implementation
 * @param headline a title for this section
 */
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
        CompareUIItem(
            ComposableTextActivity::class.java,
            AndroidUITextActivity::class.java,
            "Test"
        )
    }
}
