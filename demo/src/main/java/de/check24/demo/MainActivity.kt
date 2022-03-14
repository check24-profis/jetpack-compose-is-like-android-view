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
import de.check24.demo.features.button.AndroidUIFloatingActionButtonActivity
import de.check24.demo.features.button.AndroidUIImageButtonActivity
import de.check24.demo.features.button.ComposableCheckBoxActivity
import de.check24.demo.features.button.ComposableFloatingActionButtonActivity
import de.check24.demo.features.button.ComposableImageButtonActivity
import de.check24.demo.features.constraintlayout.AndroidUIConstraintLayoutActivity
import de.check24.demo.features.constraintlayout.ComposableConstraintLayoutActivity
import de.check24.demo.features.constraintlayout.barrier.AndroidUIBarrierActivity
import de.check24.demo.features.constraintlayout.barrier.ComposableBarrierActivity
import de.check24.demo.features.constraintlayout.guideline.AndroidUIHorizontalGuidelineActivity
import de.check24.demo.features.constraintlayout.guideline.AndroidUIVerticalGuidelineActivity
import de.check24.demo.features.constraintlayout.guideline.ComposableHorizontalGuidelineActivity
import de.check24.demo.features.constraintlayout.guideline.ComposableVerticalGuidelineActivity
import de.check24.demo.features.custom.AndroidUIGoogleMapActivity
import de.check24.demo.features.custom.ComposableGoogleMapActivity
import de.check24.demo.features.date.AndroidUIDateActivity
import de.check24.demo.features.date.ComposableDateActivity
import de.check24.demo.features.email.AndroidUIEmailActivity
import de.check24.demo.features.email.ComposableEmailActivity
import de.check24.demo.features.list.differentviews.AndroidUIListWithDifferentViewsActivity
import de.check24.demo.features.list.differentviews.ComposableListWithDifferentViewsActivity
import de.check24.demo.features.password.AndroidUIPasswordActivity
import de.check24.demo.features.password.ComposablePasswordActivity
import de.check24.demo.features.password.numeric.AndroidUINumericPasswordActivity
import de.check24.demo.features.password.numeric.ComposableNumericPasswordActivity
import de.check24.demo.features.password.visibility.AndroidUIPasswordVisibilityToggleActivity
import de.check24.demo.features.password.visibility.ComposablePasswordVisibilityToggleActivity
import de.check24.demo.features.phone.AndroidUIPhoneTextActivity
import de.check24.demo.features.phone.ComposablePhoneTextActivity
import de.check24.demo.features.radio.AndroidUIRadioButtonActivity
import de.check24.demo.features.radio.AndroidUIRadioGroupActivity
import de.check24.demo.features.radio.ComposableRadioButtonActivity
import de.check24.demo.features.radio.ComposableRadioGroupActivity
import de.check24.demo.features.switch.AndroidUISwitchActivity
import de.check24.demo.features.switch.ComposableSwitchActivity
import de.check24.demo.features.text.AndroidUITextActivity
import de.check24.demo.features.text.ComposableTextActivity
import de.check24.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val compareItems = mutableListOf<CompareItem>()
        addItemsToList(compareItems)

        setContent {
            DemoTheme {
                Menu(compareItems)
            }
        }
    }

    private fun addItemsToList(compareItems: MutableList<CompareItem>) {

        // region Text

        compareItems.add(
            CompareItem(
                composeActivity = ComposableTextActivity::class.java,
                androidUIActivity = AndroidUITextActivity::class.java,
                headline = "Text"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableEmailActivity::class.java,
                androidUIActivity = AndroidUIEmailActivity::class.java,
                headline = "Email"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposablePhoneTextActivity::class.java,
                androidUIActivity = AndroidUIPhoneTextActivity::class.java,
                headline = "Phone"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposablePasswordActivity::class.java,
                androidUIActivity = AndroidUIPasswordActivity::class.java,
                headline = "Password"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposablePasswordVisibilityToggleActivity::class.java,
                androidUIActivity = AndroidUIPasswordVisibilityToggleActivity::class.java,
                headline = "Password with visibility toggle"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableNumericPasswordActivity::class.java,
                androidUIActivity = AndroidUINumericPasswordActivity::class.java,
                headline = "Numeric Password"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableDateActivity::class.java,
                androidUIActivity = AndroidUIDateActivity::class.java,
                headline = "Date"
            )
        )

        // endregion

        // region Button

        compareItems.add(
            CompareItem(
                composeActivity = ComposableCheckBoxActivity::class.java,
                androidUIActivity = AndroidUICheckBoxActivity::class.java,
                headline = "CheckBox"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableImageButtonActivity::class.java,
                androidUIActivity = AndroidUIImageButtonActivity::class.java,
                headline = "ImageButton"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableSwitchActivity::class.java,
                androidUIActivity = AndroidUISwitchActivity::class.java,
                headline = "Switch"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableFloatingActionButtonActivity::class.java,
                androidUIActivity = AndroidUIFloatingActionButtonActivity::class.java,
                headline = "Floating Action Button"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableRadioButtonActivity::class.java,
                androidUIActivity = AndroidUIRadioButtonActivity::class.java,
                headline = "Radio Button"
            )
        )
        compareItems.add  (
            CompareItem(
                composeActivity = ComposableRadioGroupActivity::class.java,
                androidUIActivity = AndroidUIRadioGroupActivity::class.java,
                headline = "Radio Group"
            )
        )
        // endregion

        // region layout

        compareItems.add(
            CompareItem(
                composeActivity = ComposableConstraintLayoutActivity::class.java,
                androidUIActivity = AndroidUIConstraintLayoutActivity::class.java,
                headline = "Constraint Layout"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableBarrierActivity::class.java,
                androidUIActivity = AndroidUIBarrierActivity::class.java,
                headline = "Constraint Layout (Barrier)"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableVerticalGuidelineActivity::class.java,
                androidUIActivity = AndroidUIVerticalGuidelineActivity::class.java,
                headline = "Guideline Vertical"
            )
        )
        compareItems.add(
            CompareItem(
                composeActivity = ComposableHorizontalGuidelineActivity::class.java,
                androidUIActivity = AndroidUIHorizontalGuidelineActivity::class.java,
                headline = "Guideline Horizontal"
            )
        )

        // endregion

        // region List

        compareItems.add(
            CompareItem(
                composeActivity = ComposableListWithDifferentViewsActivity::class.java,
                androidUIActivity = AndroidUIListWithDifferentViewsActivity::class.java,
                headline = "List with different Views"
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

        Row {
            CompareUIItem(
                composeActivity = ComposableGoogleMapActivity::class.java,
                androidUIActivity = AndroidUIGoogleMapActivity::class.java,
                headline = "Google Maps"
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
    composeActivity: Class<out Activity>,
    androidUIActivity: Class<out Activity>,
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
        Menu(emptyList())
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
