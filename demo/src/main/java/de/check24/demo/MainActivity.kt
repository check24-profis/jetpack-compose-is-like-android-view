package de.check24.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
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
import de.check24.demo.features.button.AndroidUIImageButtonActivity
import de.check24.demo.features.button.ComposableCheckBoxActivity
import de.check24.demo.features.button.ComposableImageButtonActivity
import de.check24.demo.features.constraintlayout.AndroidUIConstraintLayoutActivity
import de.check24.demo.features.constraintlayout.ComposableConstraintLayoutActivity
import de.check24.demo.features.constraintlayout.barrier.AndroidUIBarrierActivity
import de.check24.demo.features.constraintlayout.barrier.ComposableBarrierActivity
import de.check24.demo.features.constraintlayout.guideline.AndroidUIHorizontalGuidelineActivity
import de.check24.demo.features.constraintlayout.guideline.AndroidUIVerticalGuidelineActivity
import de.check24.demo.features.constraintlayout.guideline.ComposableHorizontalGuidelineActivity
import de.check24.demo.features.constraintlayout.guideline.ComposableVerticalGuidelineActivity
import de.check24.demo.features.date.AndroidUIDateActivity
import de.check24.demo.features.date.ComposableDateActivity
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
import de.check24.demo.features.switch.AndroidUISwitchActivity
import de.check24.demo.features.switch.ComposableSwitchActivity
import de.check24.demo.features.text.AndroidUITextActivity
import de.check24.demo.features.text.ComposableTextActivity
import de.check24.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var compareItems = mutableListOf<CompareItem>()
        addItems(compareItems)

        setContent {
            DemoTheme {
                Menu(compareItems)
            }
        }
    }

    private fun addItems(compareItems: MutableList<CompareItem>) {

        // region Text

        compareItems.add(
            CompareItem(
                composeActivity = ComposableTextActivity(),
                androidUIActivity = AndroidUITextActivity(),
                headline = "Text"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableEmailActivity(),
                androidUIActivity = AndroidUIEmailActivity(),
                headline = "Email"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposablePhoneTextActivity(),
                androidUIActivity = AndroidUIPhoneTextActivity(),
                headline = "Phone"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposablePasswordActivity(),
                androidUIActivity = AndroidUIPasswordActivity(),
                headline = "Password"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposablePasswordVisibilityToggleActivity(),
                androidUIActivity = AndroidUIPasswordVisibilityToggleActivity(),
                headline = "Password with visibility toggle"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableNumericPasswordActivity(),
                androidUIActivity = AndroidUINumericPasswordActivity(),
                headline = "Numeric Password"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableDateActivity(),
                androidUIActivity = AndroidUIDateActivity(),
                headline = "Date"
            )
        )

        // endregion

        // region Button

        compareItems.add(
            CompareItem(
                composeActivity = ComposableCheckBoxActivity(),
                androidUIActivity = AndroidUICheckBoxActivity(),
                headline = "CheckBox"
            )
        )

        compareItems.add(
            CompareItem(
                composeActivity = ComposableImageButtonActivity(),
                androidUIActivity = AndroidUIImageButtonActivity(),
                headline = "ImageButton"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableSwitchActivity(),
                androidUIActivity = AndroidUISwitchActivity(),
                headline = "Switch"
            )
        )

        // endregion

        // region layout

        compareItems.add(
            CompareItem(
                composeActivity = ComposableConstraintLayoutActivity(),
                androidUIActivity = AndroidUIConstraintLayoutActivity(),
                headline = "Constraint Layout"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableBarrierActivity(),
                androidUIActivity = AndroidUIBarrierActivity(),
                headline = "Constraint Layout (Barrier)"
            )
        )

        compareItems.add(
            CompareItem(
                composeActivity = ComposableVerticalGuidelineActivity(),
                androidUIActivity = AndroidUIVerticalGuidelineActivity(),
                headline = "Guideline Vertical"
            )
        )

        compareItems.add(
            CompareItem(
                composeActivity = ComposableHorizontalGuidelineActivity(),
                androidUIActivity = AndroidUIHorizontalGuidelineActivity(),
                headline = "Guideline Horizontal"
            )
        )

        // endregion
    }
}

/**
 * Add [CompareUIItem] for every section here
 */
@Composable
private fun Menu(items: List<CompareItem>) {
    LazyColumn {

        items(items) { item ->
            CompareUIItem(
                composeActivity = item.composeActivity,
                androidUIActivity = item.androidUIActivity,
                headline = item.headline
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
private fun CompareUIItem(
    composeActivity: Activity,
    androidUIActivity: Activity,
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
                        composeActivity::class.java
                    )
                )
            }) { Text(text = "Compose") }


            Button(onClick = {
                activity?.startActivity(
                    Intent(
                        activity,
                        androidUIActivity::class.java
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
        Menu(emptyList())
    }
}

@Preview(showBackground = true, device = NEXUS_6, showSystemUi = true)
@Composable
private fun GenericItemPreview() {
    DemoTheme {
        CompareUIItem(
            ComposableTextActivity(),
            AndroidUITextActivity(),
            "Test"
        )
    }
}
