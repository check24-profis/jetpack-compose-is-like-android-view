package de.check24.compose.demo

import de.check24.compose.demo.features.appbarlayout.AndroidUIAppBarLayoutActivity
import de.check24.compose.demo.features.appbarlayout.ComposableAppBarLayoutActivity
import de.check24.compose.demo.features.bar.AndroidUIBottomAppBarActivity
import de.check24.compose.demo.features.bar.AndroidUIToolbarActivity
import de.check24.compose.demo.features.bar.ComposableBottomAppBarActivity
import de.check24.compose.demo.features.bar.ComposableToolbarActivity
import de.check24.compose.demo.features.button.AndroidUICheckBoxActivity
import de.check24.compose.demo.features.button.AndroidUIFloatingActionButtonActivity
import de.check24.compose.demo.features.button.AndroidUIImageButtonActivity
import de.check24.compose.demo.features.button.AndroidUIToggleButtonActivity
import de.check24.compose.demo.features.button.ComposableCheckBoxActivity
import de.check24.compose.demo.features.button.ComposableFloatingActionButtonActivity
import de.check24.compose.demo.features.button.ComposableImageButtonActivity
import de.check24.compose.demo.features.button.ComposableToggleButtonActivity
import de.check24.compose.demo.features.button.chip.AndroidUIChipActivity
import de.check24.compose.demo.features.button.chip.AndroidUIChipGroupActivity
import de.check24.compose.demo.features.button.chip.ComposableChipActivity
import de.check24.compose.demo.features.button.chip.ComposableChipGroupActivity
import de.check24.compose.demo.features.button.radio.AndroidUIRadioButtonActivity
import de.check24.compose.demo.features.button.radio.AndroidUIRadioGroupActivity
import de.check24.compose.demo.features.button.radio.ComposableRadioButtonActivity
import de.check24.compose.demo.features.button.radio.ComposableRadioGroupActivity
import de.check24.compose.demo.features.constraintlayout.AndroidUIConstraintLayoutActivity
import de.check24.compose.demo.features.constraintlayout.ComposableConstraintLayoutActivity
import de.check24.compose.demo.features.constraintlayout.barrier.AndroidUIBarrierActivity
import de.check24.compose.demo.features.constraintlayout.barrier.ComposableBarrierActivity
import de.check24.compose.demo.features.constraintlayout.flow.AndroidUIHelperFlowActivity
import de.check24.compose.demo.features.constraintlayout.flow.AndroidUIHelperFlowVerticalActivity
import de.check24.compose.demo.features.constraintlayout.flow.ComposableHelperFlowHorizontalActivity
import de.check24.compose.demo.features.constraintlayout.flow.ComposableHelperFlowVerticalActivity
import de.check24.compose.demo.features.constraintlayout.guideline.AndroidUIHorizontalGuidelineActivity
import de.check24.compose.demo.features.constraintlayout.guideline.AndroidUIVerticalGuidelineActivity
import de.check24.compose.demo.features.constraintlayout.guideline.ComposableHorizontalGuidelineActivity
import de.check24.compose.demo.features.constraintlayout.guideline.ComposableVerticalGuidelineActivity
import de.check24.compose.demo.features.custom.AndroidUIGoogleMapActivity
import de.check24.compose.demo.features.custom.ComposableGoogleMapActivity
import de.check24.compose.demo.features.dialog.AndroidUIAlertDialogActivity
import de.check24.compose.demo.features.dialog.ComposableAlertDialogActivity
import de.check24.compose.demo.features.email.AndroidUIEmailActivity
import de.check24.compose.demo.features.email.ComposableEmailActivity
import de.check24.compose.demo.features.events.AndroidUIEventsActivity
import de.check24.compose.demo.features.events.ComposableEventsActivity
import de.check24.compose.demo.features.framelayout.AndroidUIFrameLayoutActivity
import de.check24.compose.demo.features.framelayout.ComposableFrameLayoutActivity
import de.check24.compose.demo.features.helperlayer.AndroidUIHelperLayerActivity
import de.check24.compose.demo.features.helperlayer.ComposableHelperLayerActivity
import de.check24.compose.demo.features.list.differentviews.AndroidUIListWithDifferentViewsActivity
import de.check24.compose.demo.features.list.differentviews.ComposableListWithDifferentViewsActivity
import de.check24.compose.demo.features.list.grid.AndroidUIGridActivity
import de.check24.compose.demo.features.list.grid.ComposableGridActivity
import de.check24.compose.demo.features.list.staggered.AndroidUIStaggeredListActivity
import de.check24.compose.demo.features.list.staggered.ComposableStaggeredListActivity
import de.check24.compose.demo.features.modifier.AndroidUIModifierActivity
import de.check24.compose.demo.features.modifier.ComposableModifierActivity
import de.check24.compose.demo.features.navigation.AndroidUINavHostActivity
import de.check24.compose.demo.features.navigation.ComposableNavHostActivity
import de.check24.compose.demo.features.observables.AndroidUIObservableTypesActivity
import de.check24.compose.demo.features.observables.ComposableObservableTypesActivity
import de.check24.compose.demo.features.password.AndroidUIPasswordActivity
import de.check24.compose.demo.features.password.ComposablePasswordActivity
import de.check24.compose.demo.features.password.numeric.AndroidUINumericPasswordActivity
import de.check24.compose.demo.features.password.numeric.ComposableNumericPasswordActivity
import de.check24.compose.demo.features.password.visibility.AndroidUIPasswordVisibilityToggleActivity
import de.check24.compose.demo.features.password.visibility.ComposablePasswordVisibilityToggleActivity
import de.check24.compose.demo.features.phone.AndroidUIPhoneTextActivity
import de.check24.compose.demo.features.phone.ComposablePhoneTextActivity
import de.check24.compose.demo.features.picker.AndroidUIDateActivity
import de.check24.compose.demo.features.picker.AndroidUITimeActivity
import de.check24.compose.demo.features.picker.ComposableDateActivity
import de.check24.compose.demo.features.picker.ComposableTimeActivity
import de.check24.compose.demo.features.positioning.AndroidUIConstraintLayoutPositioningActivity
import de.check24.compose.demo.features.positioning.AndroidUIFlowActivity
import de.check24.compose.demo.features.positioning.AndroidUIHorizontalLinearLayoutActivity
import de.check24.compose.demo.features.positioning.AndroidUIVerticalLinearLayoutActivity
import de.check24.compose.demo.features.positioning.ComposableConstraintLayoutPositioningActivity
import de.check24.compose.demo.features.positioning.ComposableFlowActivity
import de.check24.compose.demo.features.positioning.ComposableHorizontalLinearLayoutActivity
import de.check24.compose.demo.features.positioning.ComposableVerticalLinearLayoutActivity
import de.check24.compose.demo.features.spinner.AndroidUISpinnerActivity
import de.check24.compose.demo.features.spinner.ComposableSpinnerActivity
import de.check24.compose.demo.features.stateful.AndroidUIStatefulActivity
import de.check24.compose.demo.features.stateful.ComposableStatefulActivity
import de.check24.compose.demo.features.stateholder.AndroidUIStateHolderActivity
import de.check24.compose.demo.features.stateholder.ComposableStateHolderActivity
import de.check24.compose.demo.features.stateless.AndroidUIStatelessActivity
import de.check24.compose.demo.features.stateless.ComposableStatelessActivity
import de.check24.compose.demo.features.switch.AndroidUISwitchActivity
import de.check24.compose.demo.features.switch.ComposableSwitchActivity
import de.check24.compose.demo.features.tablayout.AndroidUITabItemActivity
import de.check24.compose.demo.features.tablayout.AndroidUITabLayoutActivity
import de.check24.compose.demo.features.tablayout.ComposableTabItemActivity
import de.check24.compose.demo.features.tablayout.ComposableTabLayoutActivity
import de.check24.compose.demo.features.text.AndroidUIAutoCompleteActivity
import de.check24.compose.demo.features.text.AndroidUIMultilineTextActivity
import de.check24.compose.demo.features.text.AndroidUINumberActivity
import de.check24.compose.demo.features.text.AndroidUINumberDecimalActivity
import de.check24.compose.demo.features.text.AndroidUINumberSignedActivity
import de.check24.compose.demo.features.text.AndroidUIPostalAddressActivity
import de.check24.compose.demo.features.text.AndroidUITextActivity
import de.check24.compose.demo.features.text.AndroidUITextInputActivity
import de.check24.compose.demo.features.text.ComposableAutoCompleteActivity
import de.check24.compose.demo.features.text.ComposableMultilineTextActivity
import de.check24.compose.demo.features.text.ComposableNumberActivity
import de.check24.compose.demo.features.text.ComposableNumberDecimalActivity
import de.check24.compose.demo.features.text.ComposableNumberSignedActivity
import de.check24.compose.demo.features.text.ComposablePostalAddressActivity
import de.check24.compose.demo.features.text.ComposableTextActivity
import de.check24.compose.demo.features.text.ComposableTextInputActivity
import de.check24.compose.demo.features.theme.AndroidUIThemeActivity
import de.check24.compose.demo.features.theme.ComposableThemeActivity
import de.check24.compose.demo.features.viewmodel.AndroidUIViewModelActivity
import de.check24.compose.demo.features.viewmodel.ComposableViewModelActivity
import de.check24.compose.demo.features.viewpager.AndroidUIViewPagerActivity
import de.check24.compose.demo.features.viewpager.ComposableViewPagerActivity

internal val compareItemList: List<CompareItem> by lazy {
    val compareItems = mutableListOf<CompareItem>()

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
            composeActivity = ComposableMultilineTextActivity::class.java,
            androidUIActivity = AndroidUIMultilineTextActivity::class.java,
            headline = "Multiline Text"
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
    compareItems.add(
        CompareItem(
            composeActivity = ComposableAutoCompleteActivity::class.java,
            androidUIActivity = AndroidUIAutoCompleteActivity::class.java,
            headline = "Auto Complete"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableTimeActivity::class.java,
            androidUIActivity = AndroidUITimeActivity::class.java,
            headline = "Time"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableTextInputActivity::class.java,
            androidUIActivity = AndroidUITextInputActivity::class.java,
            headline = "Text Input"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableNumberSignedActivity::class.java,
            androidUIActivity = AndroidUINumberSignedActivity::class.java,
            headline = "Number Signed"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableNumberActivity::class.java,
            androidUIActivity = AndroidUINumberActivity::class.java,
            headline = "Number"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableNumberDecimalActivity::class.java,
            androidUIActivity = AndroidUINumberDecimalActivity::class.java,
            headline = "Number Decimal"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposablePostalAddressActivity::class.java,
            androidUIActivity = AndroidUIPostalAddressActivity::class.java,
            headline = "Postal Address"
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
    compareItems.add(
        CompareItem(
            composeActivity = ComposableRadioGroupActivity::class.java,
            androidUIActivity = AndroidUIRadioGroupActivity::class.java,
            headline = "Radio Group"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableToggleButtonActivity::class.java,
            androidUIActivity = AndroidUIToggleButtonActivity::class.java,
            headline = "Toggle Button"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableChipActivity::class.java,
            androidUIActivity = AndroidUIChipActivity::class.java,
            headline = "Chip"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableChipGroupActivity::class.java,
            androidUIActivity = AndroidUIChipGroupActivity::class.java,
            headline = "Chip Group"
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
    compareItems.add(
        CompareItem(
            composeActivity = ComposableTabLayoutActivity::class.java,
            androidUIActivity = AndroidUITabLayoutActivity::class.java,
            headline = "Tab Layout"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableFrameLayoutActivity::class.java,
            androidUIActivity = AndroidUIFrameLayoutActivity::class.java,
            headline = "Frame Layout"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableHelperLayerActivity::class.java,
            androidUIActivity = AndroidUIHelperLayerActivity::class.java,
            headline = "Helper (Layer)"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableHelperFlowHorizontalActivity::class.java,
            androidUIActivity = AndroidUIHelperFlowActivity::class.java,
            headline = "Helper (Flow Horizontal)"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableHelperFlowVerticalActivity::class.java,
            androidUIActivity = AndroidUIHelperFlowVerticalActivity::class.java,
            headline = "Helper (Flow Vertical)"
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
    compareItems.add(
        CompareItem(
            composeActivity = ComposableStaggeredListActivity::class.java,
            androidUIActivity = AndroidUIStaggeredListActivity::class.java,
            headline = "Staggered Grid"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableGridActivity::class.java,
            androidUIActivity = AndroidUIGridActivity::class.java,
            headline = "Grid"
        )
    )
    // endregion

    // region container

    compareItems.add(
        CompareItem(
            composeActivity = ComposableBottomAppBarActivity::class.java,
            androidUIActivity = AndroidUIBottomAppBarActivity::class.java,
            headline = "Bottom App Bar"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableSpinnerActivity::class.java,
            androidUIActivity = AndroidUISpinnerActivity::class.java,
            headline = "Spinner"
        )
    )

    compareItems.add(
        CompareItem(
            composeActivity = ComposableViewPagerActivity::class.java,
            androidUIActivity = AndroidUIViewPagerActivity::class.java,
            headline = "View Pager"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableNavHostActivity::class.java,
            androidUIActivity = AndroidUINavHostActivity::class.java,
            headline = "NavHost"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableAppBarLayoutActivity::class.java,
            androidUIActivity = AndroidUIAppBarLayoutActivity::class.java,
            headline = "App Bar Layout"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableTabItemActivity::class.java,
            androidUIActivity = AndroidUITabItemActivity::class.java,
            headline = "TabItem"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableToolbarActivity::class.java,
            androidUIActivity = AndroidUIToolbarActivity::class.java,
            headline = "Toolbar"
        )
    )

    // endregion

    // region modifier

    compareItems.add(
        CompareItem(
            composeActivity = ComposableModifierActivity::class.java,
            androidUIActivity = AndroidUIModifierActivity::class.java,
            headline = "Modifier"
        )
    )

    // endregion

    // region custom

    compareItems.add(
        CompareItem(
            composeActivity = ComposableGoogleMapActivity::class.java,
            androidUIActivity = AndroidUIGoogleMapActivity::class.java,
            headline = "Google Maps"
        )
    )

    // endregion

    // region positioning

    compareItems.add(
        CompareItem(
            composeActivity = ComposableConstraintLayoutPositioningActivity::class.java,
            androidUIActivity = AndroidUIConstraintLayoutPositioningActivity::class.java,
            headline = "ConstraintLayout Positioning"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableVerticalLinearLayoutActivity::class.java,
            androidUIActivity = AndroidUIVerticalLinearLayoutActivity::class.java,
            headline = "LinearLayout (Vertical)"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableHorizontalLinearLayoutActivity::class.java,
            androidUIActivity = AndroidUIHorizontalLinearLayoutActivity::class.java,
            headline = "LinearLayout (Horizontal)"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableGridActivity::class.java,
            androidUIActivity = AndroidUIGridActivity::class.java,
            headline = "GridLayout"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableFrameLayoutActivity::class.java,
            androidUIActivity = AndroidUIFrameLayoutActivity::class.java,
            headline = "FrameLayout Positioning"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableFlowActivity::class.java,
            androidUIActivity = AndroidUIFlowActivity::class.java,
            headline = "Flow"
        )
    )

    // endregion

    // region theme

    compareItems.add(
        CompareItem(
            composeActivity = ComposableThemeActivity::class.java,
            androidUIActivity = AndroidUIThemeActivity::class.java,
            headline = "Theme"
        )
    )

    // endregion

    // region states

    compareItems.add(
        CompareItem(
            composeActivity = ComposableStatefulActivity::class.java,
            androidUIActivity = AndroidUIStatefulActivity::class.java,
            headline = "Stateful"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableStatelessActivity::class.java,
            androidUIActivity = AndroidUIStatelessActivity::class.java,
            headline = "Stateless"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableStateHolderActivity::class.java,
            androidUIActivity = AndroidUIStateHolderActivity::class.java,
            headline = "State Holder"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableObservableTypesActivity::class.java,
            androidUIActivity = AndroidUIObservableTypesActivity::class.java,
            headline = "Observable types"
        )
    )
    compareItems.add(
        CompareItem(
            composeActivity = ComposableViewModelActivity::class.java,
            androidUIActivity = AndroidUIViewModelActivity::class.java,
            headline = "ViewModel"
        )
    )

    // endregion

    // region events

    compareItems.add(
        CompareItem(
            composeActivity = ComposableEventsActivity::class.java,
            androidUIActivity = AndroidUIEventsActivity::class.java,
            headline = "Events"
        )
    )

    // endregion

    //region dialogs

    compareItems.add(
        CompareItem(
            composeActivity = ComposableAlertDialogActivity::class.java,
            androidUIActivity = AndroidUIAlertDialogActivity::class.java,
            headline = "AlertDialog"
        )
    )

    compareItems
}
